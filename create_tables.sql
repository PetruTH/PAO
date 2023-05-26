create table Angajat(
    id int primary key,
    nume varchar(255),
    mail varchar(255),
    varsta int,
    salariu int,
    pozitie varchar(255)
);


create table Client
(
    nrcontact varchar(255) primary key,
    nume      varchar(255),
    mail      varchar(255),
    varsta    int,
    produse   varchar(255)
);

create table DealerShip(
    id int primary key,
    nume varchar(255),
    clienti varchar(255),
    angajati varchar(255),
    produse varchar(255),
    sediu varchar(255)
);

create table sediu(
    locatie varchar(255) primary key,
    nrStocuri int
);

create table ATV(
    serieFabricatie varchar(255) primary key,
    pret int,
    marca varchar(255),
    terenSuportat varchar(255),
    nivelDeSiguranta int,
    autonomie int,
    tractiune varchar(255)
);

create table Bicicleta(
    serieFabricatie varchar(255) primary key,
    pret int,
    marca varchar(255),
    terenSuportat varchar(255),
    nivelDeSiguranta int,
    masa int,
    nrViteze int,
    materialCadru varchar(255)
);

create table Motocicleta(
    serieFabricatie varchar(255) primary key,
    pret int,
    marca varchar(255),
    terenSuportat varchar(255),
    nivelDeSiguranta int,
    capacitateCilindrica int,
    transmisie varchar(255),
    tipMotocicleta varchar(255)
);

create table MasinaCombustibilFosil(
    serieFabricatie varchar(255) primary key,
    pret int,
    marca varchar(255),
    tip varchar(255),
    putere int,
    vitezaMaxima int,
    masa int,
    capacitateMotor int,
    tipCombustibil varchar(255)
);

create table MasinaElectrica(
    serieFabricatie varchar(255) primary key,
    pret int,
    marca varchar(255),
    tip varchar(255),
    putere int,
    vitezaMaxima int,
    masa int,
    autonomie int
                            );

create table MasinaHybrid(
    serieFabricatie varchar(255) primary key,
    pret int,
    marca varchar(255),
    tip varchar(255),
    putere int,
    vitezaMaxima int,
    masa int,
    capacitateMotor int,
    tipCombustibil varchar(255),
    autonomie int
    );