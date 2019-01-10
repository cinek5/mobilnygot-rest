package com.example.cinek;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;

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

    public static void StartDbTcpServer()
    {
        try
        {
            org.h2.tools.Server server = org.h2.tools.Server.createTcpServer().start();
        }
        catch (Exception e)  { e.printStackTrace(); }
    }
}
