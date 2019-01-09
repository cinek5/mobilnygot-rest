drop table GrupaGorska if exists
drop table Pamiatka if exists
drop table Przodownik if exists
drop table PunktTrasy if exists
drop table SkladowyPunktTrasy if exists
drop table Trasa if exists
drop table TrasaSkladowa if exists
drop table Turysta if exists
drop table uprawnienia_przodownikow if exists
drop table Wedrowka if exists
drop sequence if exists hibernate_sequence
create sequence hibernate_sequence start with 1 increment by 1
create table GrupaGorska (id bigint not null, nazwaGrupy varchar(255), primary key (id))
create table Pamiatka (id bigint not null, czyDokumentujaca boolean, czyPubliczna boolean, zdjecie BLOB, trasaSkladowa_id bigint, primary key (id))
create table Przodownik (id bigint not null, imie varchar(255), nazwisko varchar(255), primary key (id))
create table PunktTrasy (id bigint not null, nazwaPunktu varchar(255), szerokoscGeograficzna float, wysokosc integer, wysokoscGeograficzna float, primary key (id))
create table SkladowyPunktTrasy (kolejnoscPunktu integer not null, trasa_id bigint not null, punktTrasy_id bigint not null, primary key (trasa_id, punktTrasy_id, kolejnoscPunktu))
create table Trasa (typ_trasy varchar(31) not null, id bigint not null, punktyRegulaminowe integer, dataDodania timestamp, dataUsuniecia timestamp, nazwa varchar(255), poprzedniaWersjaId bigint, grupaGorska_id bigint, primary key (id))
create table TrasaSkladowa (id bigint not null, status integer, trasa_id bigint, verifyPrzodownik_id bigint, wedrowka_id bigint, primary key (id))
create table Turysta (id bigint not null, imie varchar(255), nazwisko varchar(255), zgromadzonePunkty integer, primary key (id))
create table uprawnienia_przodownikow (przodownik_id bigint not null, GrupaGorska_id bigint not null)
create table Wedrowka (id bigint not null, dataWedrowki timestamp, nazwaWedrowki varchar(255), punktyZaWedrowke integer, turysta_id bigint, primary key (id))
alter table GrupaGorska add constraint UK_qago9je7jyikl2g5nqpb1e48g unique (nazwaGrupy)
alter table SkladowyPunktTrasy add constraint UK_o93ct90imjgx9k6k4i0yvscqc unique (punktTrasy_id)
alter table Trasa add constraint UK_bj6pqlmve686myp4d2g60sh19 unique (nazwa)
alter table Pamiatka add constraint FKnjustitry5fwiq1m58ryophs0 foreign key (trasaSkladowa_id) references TrasaSkladowa
alter table SkladowyPunktTrasy add constraint FKgh257h7fmvp9n55g5p9glevnu foreign key (trasa_id) references Trasa
alter table SkladowyPunktTrasy add constraint FK65w30drmcu8l3s9bu30jv1s8f foreign key (punktTrasy_id) references PunktTrasy
alter table Trasa add constraint FK73bt2voekbp1imsjt95jqt8e6 foreign key (grupaGorska_id) references GrupaGorska
alter table TrasaSkladowa add constraint FKe2sm6rsmcjy7rnk8shsia7j3f foreign key (trasa_id) references Trasa
alter table TrasaSkladowa add constraint FKhpmkorgu966isw1hhrk16i54m foreign key (verifyPrzodownik_id) references Przodownik
alter table TrasaSkladowa add constraint FKdxyfjiq3x7xrj05ee3cng6oy4 foreign key (wedrowka_id) references Wedrowka
alter table uprawnienia_przodownikow add constraint FKpp5dn8pnbhs1yqp34qkn96ygv foreign key (GrupaGorska_id) references GrupaGorska
alter table uprawnienia_przodownikow add constraint FKg2m7pvao2c65p99wckctdsa8n foreign key (przodownik_id) references Przodownik
alter table Wedrowka add constraint FKlp93q93hr8i41xrnq2hqdriah foreign key (turysta_id) references Turysta
