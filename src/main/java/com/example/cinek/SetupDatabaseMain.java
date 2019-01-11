package com.example.cinek;

import org.h2.util.IOUtils;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.embedded.ConnectionProperties;
import sun.nio.ch.IOUtil;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;
import java.util.EnumSet;

public class SetupDatabaseMain
{
    public static void main(String [] args)
    {
        createSchemaWithHibernate();
    }

    public static void createSchemaWithHibernate()
    {
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();
        Metadata metadata = new MetadataSources(serviceRegistry)
                .buildMetadata();

        new SchemaExport()
                .setOutputFile("db-schema.hibernate5.sql")
                .create(EnumSet.of(TargetType.SCRIPT), metadata);

        metadata.buildSessionFactory().close();
    }

    public static void startDbTcpServer()
    {
        try
        {
            org.h2.tools.Server server = org.h2.tools.Server.createTcpServer().start();
        }
        catch (Exception e)  { e.printStackTrace(); }
    }

    public static void insertData()
    {
        String[] statements =
        {
                "insert into GRUPA_GORSKA select * FROM CSVREAD('src/main/resources/DbData/GrupaGorska.csv', null, 'charset=UTF-8 fieldSeparator=;')",
                "insert into PRZODOWNIK select * FROM CSVREAD('src/main/resources/DbData/Przodownik.csv', null, 'charset=UTF-8 fieldSeparator=;')",
                "insert into TURYSTA select * FROM CSVREAD('src/main/resources/DbData/Turysta.csv', null, 'charset=UTF-8 fieldSeparator=;')",
                "insert into UPRAWNIENIA_PRZODOWNIKOW select * FROM CSVREAD('src/main/resources/DbData/Uprawnienia_Przodownikow.csv', null, 'charset=UTF-8 fieldSeparator=;')",
                "insert into WEDROWKA select * FROM CSVREAD('src/main/resources/DbData/Wedrowka.csv', null, 'charset=UTF-8 fieldSeparator=;')",
                "insert into PUNKT_TRASY select * FROM CSVREAD('src/main/resources/DbData/PunktTrasy.csv', null, 'charset=UTF-8 fieldSeparator=;')",
                "insert into TRASA select * FROM CSVREAD('src/main/resources/DbData/Trasa.csv', null, 'charset=UTF-8 fieldSeparator=;')",
                "insert into SKLADOWY_PUNKT_TRASY select * FROM CSVREAD('src/main/resources/DbData/SkladowyPunktTrasy.csv', null, 'charset=UTF-8 fieldSeparator=;')",
                "insert into TRASA_SKLADOWA select * FROM CSVREAD('src/main/resources/DbData/TrasaSkladowa.csv', null, 'charset=UTF-8 fieldSeparator=;')",
                "insert into PAMIATKA select * FROM CSVREAD('src/main/resources/DbData/Pamiatka.csv', null, 'charset=UTF-8 fieldSeparator=;')"
        };
        Connection conn = null;
        try
        {
            conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/mem:default",
                    "sa", "");
            //conn.createStatement().execute("SET REFERENTIAL_INTEGRITY FALSE");
            for(String statement : statements)
            {
                conn.createStatement().execute(statement);
            }
            insertPhotos(conn);
            //testPhotos(conn);
        }
        catch (Exception e) { e.printStackTrace(); }

        try
        {
            //conn.createStatement().execute("SET REFERENTIAL_INTEGRITY TRUE");
        }
        catch (Exception e) { e.printStackTrace(); }
    }

    private static void insertPhotos(Connection conn) throws SQLException
    {
        Statement statement = conn.createStatement();
        statement.execute("SELECT ID FROM PAMIATKA");
        while(statement.getResultSet().next())
        {
            Long id = statement.getResultSet().getLong(1);
            String sql = String.format("UPDATE PAMIATKA SET ZDJECIE=(FILE_READ" +
                    "('src/main/resources/DbData/photos/photo_%d.jpg')) WHERE ID=%d", id, id);
            conn.createStatement().execute(sql);
        }
    }

    private static void testPhotos(Connection conn) throws SQLException, IOException
    {
        Statement statement = conn.createStatement();
        statement.execute("SELECT ZDJECIE FROM PAMIATKA");
        int index = 1;
        while(statement.getResultSet().next())
        {
            Blob blob = statement.getResultSet().getBlob(1);
            InputStream in = blob.getBinaryStream();
            String path = String.format("src/main/resources/DbData/photosWritten/photo_%d.jpg", index);
            OutputStream out = new FileOutputStream(path);
            IOUtils.copy(in, out);
            in.close();
            out.close();
            index++;
        }
    }
}
