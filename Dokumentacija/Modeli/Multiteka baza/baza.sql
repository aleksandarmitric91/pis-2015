/*==============================================================*/
/* DBMS name:      Microsoft SQL Server 2008                    */
/* Created on:     05-Jun-2015 13:46:05                         */
/*==============================================================*/


if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('AKT_O_ORGANIZACIJI') and o.name = 'FK_AKT_O_OR_AKT_O_ORG_ORGANIZA')
alter table AKT_O_ORGANIZACIJI
   drop constraint FK_AKT_O_OR_AKT_O_ORG_ORGANIZA
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ARTIKLI_I_PRIMJERCI') and o.name = 'FK_ARTIKLI__POSJEDUJE_PRAVNO_L')
alter table ARTIKLI_I_PRIMJERCI
   drop constraint FK_ARTIKLI__POSJEDUJE_PRAVNO_L
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ARTIKLI_I_PRIMJERCI') and o.name = 'FK_ARTIKLI__SU_PRIMJE_NASLOVI_')
alter table ARTIKLI_I_PRIMJERCI
   drop constraint FK_ARTIKLI__SU_PRIMJE_NASLOVI_
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ARTIKLI_NA_RAZMJENI') and o.name = 'FK_ARTIKLI__KOJI_ARTI_ARTIKLI_')
alter table ARTIKLI_NA_RAZMJENI
   drop constraint FK_ARTIKLI__KOJI_ARTI_ARTIKLI_
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ARTIKLI_NA_RAZMJENI') and o.name = 'FK_ARTIKLI__SA_KIM_SE_OSTVAREN')
alter table ARTIKLI_NA_RAZMJENI
   drop constraint FK_ARTIKLI__SA_KIM_SE_OSTVAREN
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('CJENOVNIK') and o.name = 'FK_CJENOVNI_KOJE_ARTI_NASLOVI_')
alter table CJENOVNIK
   drop constraint FK_CJENOVNI_KOJE_ARTI_NASLOVI_
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('CJENOVNIK') and o.name = 'FK_CJENOVNI_KOJE_PRAV_PRAVNO_L')
alter table CJENOVNIK
   drop constraint FK_CJENOVNI_KOJE_PRAV_PRAVNO_L
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('CJENOVNIK') and o.name = 'FK_CJENOVNI_KOJE_USLU_TIP_USLU')
alter table CJENOVNIK
   drop constraint FK_CJENOVNI_KOJE_USLU_TIP_USLU
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('CJENOVNIK') and o.name = 'FK_CJENOVNI_KOJI_TIP__TIP_CLAN')
alter table CJENOVNIK
   drop constraint FK_CJENOVNI_KOJI_TIP__TIP_CLAN
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('CLANSKA_KARTA') and o.name = 'FK_CLANSKA__CIJI_CU_K_PRAVNO_L')
alter table CLANSKA_KARTA
   drop constraint FK_CLANSKA__CIJI_CU_K_PRAVNO_L
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('CLANSKA_KARTA') and o.name = 'FK_CLANSKA__IMAJU_CLA_KLIJENTI')
alter table CLANSKA_KARTA
   drop constraint FK_CLANSKA__IMAJU_CLA_KLIJENTI
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('CLANSKA_KARTA') and o.name = 'FK_CLANSKA__TIPICAZIJ_TIP_CLAN')
alter table CLANSKA_KARTA
   drop constraint FK_CLANSKA__TIPICAZIJ_TIP_CLAN
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('DJELATNOST') and o.name = 'FK_DJELATNO_DJELATNOS_PRAVNO_L')
alter table DJELATNOST
   drop constraint FK_DJELATNO_DJELATNOS_PRAVNO_L
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('DJELATNOST') and o.name = 'FK_DJELATNO_DJELATNOS_REGISTAR')
alter table DJELATNOST
   drop constraint FK_DJELATNO_DJELATNOS_REGISTAR
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('DRZAVA') and o.name = 'FK_DRZAVA_GLAVNI_GR_NASELJEN')
alter table DRZAVA
   drop constraint FK_DRZAVA_GLAVNI_GR_NASELJEN
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('DRZAVA') and o.name = 'FK_DRZAVA_PRAVNI_NA_DRZAVA')
alter table DRZAVA
   drop constraint FK_DRZAVA_PRAVNI_NA_DRZAVA
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('MJESTA_U_DRZAVI') and o.name = 'FK_MJESTA_U_NALAZI_SE_NASELJEN')
alter table MJESTA_U_DRZAVI
   drop constraint FK_MJESTA_U_NALAZI_SE_NASELJEN
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('MJESTA_U_DRZAVI') and o.name = 'FK_MJESTA_U_SADRZI_MJ_DRZAVA')
alter table MJESTA_U_DRZAVI
   drop constraint FK_MJESTA_U_SADRZI_MJ_DRZAVA
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('NASLOVI_I_OPIS') and o.name = 'FK_NASLOVI__TIPIZACIJ_TIP_ARTI')
alter table NASLOVI_I_OPIS
   drop constraint FK_NASLOVI__TIPIZACIJ_TIP_ARTI
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('OBAVLJENE_USLUGE') and o.name = 'FK_OBAVLJEN_KO_ZAHTJE_CLANSKA_')
alter table OBAVLJENE_USLUGE
   drop constraint FK_OBAVLJEN_KO_ZAHTJE_CLANSKA_
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('OBAVLJENE_USLUGE') and o.name = 'FK_OBAVLJEN_SA_KOJIM__ARTIKLI_')
alter table OBAVLJENE_USLUGE
   drop constraint FK_OBAVLJEN_SA_KOJIM__ARTIKLI_
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('OBAVLJENE_USLUGE') and o.name = 'FK_OBAVLJEN_TIPIZACIJ_TIP_USLU')
alter table OBAVLJENE_USLUGE
   drop constraint FK_OBAVLJEN_TIPIZACIJ_TIP_USLU
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('OPSTINE') and o.name = 'FK_OPSTINE_LOKALNA_S_DRZAVA')
alter table OPSTINE
   drop constraint FK_OPSTINE_LOKALNA_S_DRZAVA
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('OPSTINE') and o.name = 'FK_OPSTINE_SEDISTE_O_NASELJEN')
alter table OPSTINE
   drop constraint FK_OPSTINE_SEDISTE_O_NASELJEN
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ORGANIZACIJA') and o.name = 'FK_ORGANIZA_ORGANIZAC_AKT_O_OR')
alter table ORGANIZACIJA
   drop constraint FK_ORGANIZA_ORGANIZAC_AKT_O_OR
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ORGANIZACIJA') and o.name = 'FK_ORGANIZA_ORGANIZAC_ORGANIZA')
alter table ORGANIZACIJA
   drop constraint FK_ORGANIZA_ORGANIZAC_ORGANIZA
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ORGANIZACIONA_JEDINICA') and o.name = 'FK_ORGANIZA_ORGANIZAC_PRAVNO_L')
alter table ORGANIZACIONA_JEDINICA
   drop constraint FK_ORGANIZA_ORGANIZAC_PRAVNO_L
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ORGANIZACIONA_JEDINICA') and o.name = 'FK_ORGANIZA_SEDISTE_J_NASELJEN')
alter table ORGANIZACIONA_JEDINICA
   drop constraint FK_ORGANIZA_SEDISTE_J_NASELJEN
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('OSTVARENE_SARADNJE') and o.name = 'FK_OSTVAREN_KOJA_MULT_PRAVNO_L')
alter table OSTVARENE_SARADNJE
   drop constraint FK_OSTVAREN_KOJA_MULT_PRAVNO_L
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('OSTVARENE_SARADNJE') and o.name = 'FK_OSTVAREN_KOJI_PART_PRAVNO_L')
alter table OSTVARENE_SARADNJE
   drop constraint FK_OSTVAREN_KOJI_PART_PRAVNO_L
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('OSTVARENE_SARADNJE') and o.name = 'FK_OSTVAREN_TIPIZACIJ_TIP_SARA')
alter table OSTVARENE_SARADNJE
   drop constraint FK_OSTVAREN_TIPIZACIJ_TIP_SARA
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('PODACI_ZA_LOGOVANJE') and o.name = 'FK_PODACI_Z_KORISNICI_KLIJENTI')
alter table PODACI_ZA_LOGOVANJE
   drop constraint FK_PODACI_Z_KORISNICI_KLIJENTI
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('PODACI_ZA_LOGOVANJE') and o.name = 'FK_PODACI_Z_KORISNICI_REGISTAR')
alter table PODACI_ZA_LOGOVANJE
   drop constraint FK_PODACI_Z_KORISNICI_REGISTAR
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('PODACI_ZA_LOGOVANJE') and o.name = 'FK_PODACI_Z_TIPIZACIJ_TIP_KORI')
alter table PODACI_ZA_LOGOVANJE
   drop constraint FK_PODACI_Z_TIPIZACIJ_TIP_KORI
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('POTREBA_ZA') and o.name = 'FK_POTREBA__KOJIH_ART_NASLOVI_')
alter table POTREBA_ZA
   drop constraint FK_POTREBA__KOJIH_ART_NASLOVI_
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('POTREBA_ZA') and o.name = 'FK_POTREBA__POTREBA_Z_PRAVNO_L')
alter table POTREBA_ZA
   drop constraint FK_POTREBA__POTREBA_Z_PRAVNO_L
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('POTREBA_ZA') and o.name = 'FK_POTREBA__TIPIZACIJ_TIP_PROI')
alter table POTREBA_ZA
   drop constraint FK_POTREBA__TIPIZACIJ_TIP_PROI
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('PRAVNO_LICE') and o.name = 'FK_PRAVNO_L_PRAVNI_NA_PRAVNO_L')
alter table PRAVNO_LICE
   drop constraint FK_PRAVNO_L_PRAVNI_NA_PRAVNO_L
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('PRAVNO_LICE') and o.name = 'FK_PRAVNO_L_REGISTROV_DRZAVA')
alter table PRAVNO_LICE
   drop constraint FK_PRAVNO_L_REGISTROV_DRZAVA
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('PRAVNO_LICE') and o.name = 'FK_PRAVNO_L_SEDISTE_P_NASELJEN')
alter table PRAVNO_LICE
   drop constraint FK_PRAVNO_L_SEDISTE_P_NASELJEN
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('PROMOCIJE') and o.name = 'FK_PROMOCIJ_SE_PROMOV_PRAVNO_L')
alter table PROMOCIJE
   drop constraint FK_PROMOCIJ_SE_PROMOV_PRAVNO_L
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('PROMOCIJE') and o.name = 'FK_PROMOCIJ_VRSTE_PRO_TIP_PROM')
alter table PROMOCIJE
   drop constraint FK_PROMOCIJ_VRSTE_PRO_TIP_PROM
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('RASPORED_RADNIH_MJESTA') and o.name = 'FK_RASPORED_RADI_REGISTAR')
alter table RASPORED_RADNIH_MJESTA
   drop constraint FK_RASPORED_RADI_REGISTAR
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('RASPORED_RADNIH_MJESTA') and o.name = 'FK_RASPORED_R_MJESTO_SISTEMAT')
alter table RASPORED_RADNIH_MJESTA
   drop constraint FK_RASPORED_R_MJESTO_SISTEMAT
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('REGION') and o.name = 'FK_REGION_PRIPADA_D_DRZAVA')
alter table REGION
   drop constraint FK_REGION_PRIPADA_D_DRZAVA
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('REGION') and o.name = 'FK_REGION_SEDISTE_R_NASELJEN')
alter table REGION
   drop constraint FK_REGION_SEDISTE_R_NASELJEN
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('REGION') and o.name = 'FK_REGION_TIPIZACIJ_TIP_REGI')
alter table REGION
   drop constraint FK_REGION_TIPIZACIJ_TIP_REGI
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('REGIONALNA_DRZAVA') and o.name = 'FK_REGIONAL_REGIONI_D_DRZAVA')
alter table REGIONALNA_DRZAVA
   drop constraint FK_REGIONAL_REGIONI_D_DRZAVA
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('REGIONALNA_DRZAVA') and o.name = 'FK_REGIONAL_REGION_U__REGION')
alter table REGIONALNA_DRZAVA
   drop constraint FK_REGIONAL_REGION_U__REGION
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('REGISTAR_DJELATNOSTI') and o.name = 'FK_REGISTAR_ZA_DRZAVU_DRZAVA')
alter table REGISTAR_DJELATNOSTI
   drop constraint FK_REGISTAR_ZA_DRZAVU_DRZAVA
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('REGISTAR_ZAPOSLENIH') and o.name = 'FK_REGISTAR_ZAPOSLENI_PRAVNO_L')
alter table REGISTAR_ZAPOSLENIH
   drop constraint FK_REGISTAR_ZAPOSLENI_PRAVNO_L
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('SISTEMATIZACIJA_RADNIH_MJESTA') and o.name = 'FK_SISTEMAT_RADNA_MJE_PRAVNO_L')
alter table SISTEMATIZACIJA_RADNIH_MJESTA
   drop constraint FK_SISTEMAT_RADNA_MJE_PRAVNO_L
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('SLOZENA_DRZAVA') and o.name = 'FK_SLOZENA__CLANICA_DRZAVA')
alter table SLOZENA_DRZAVA
   drop constraint FK_SLOZENA__CLANICA_DRZAVA
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('SLOZENA_DRZAVA') and o.name = 'FK_SLOZENA__SLOZENA_DRZAVA')
alter table SLOZENA_DRZAVA
   drop constraint FK_SLOZENA__SLOZENA_DRZAVA
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('STRUKTURA_NASELJA') and o.name = 'FK_STRUKTUR_STRUKTURA_NASELJEN')
alter table STRUKTURA_NASELJA
   drop constraint FK_STRUKTUR_STRUKTURA_NASELJEN
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('STRUKTURA_NASELJA') and o.name = 'FK_STRUKTUR_STRUKTURA_OPSTINE')
alter table STRUKTURA_NASELJA
   drop constraint FK_STRUKTUR_STRUKTURA_OPSTINE
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('STRUKTURA_REGIONA') and o.name = 'FK_STRUKTUR_STRUKTURA_REGION')
alter table STRUKTURA_REGIONA
   drop constraint FK_STRUKTUR_STRUKTURA_REGION
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('STRUKTURA_REGIONA') and o.name = 'FK_STRUKTUR_STRUKTURA_REGION2')
alter table STRUKTURA_REGIONA
   drop constraint FK_STRUKTUR_STRUKTURA_REGION2
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('AKT_O_ORGANIZACIJI')
            and   name  = 'AKT_O_ORGANIZACIJI_FK'
            and   indid > 0
            and   indid < 255)
   drop index AKT_O_ORGANIZACIJI.AKT_O_ORGANIZACIJI_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('AKT_O_ORGANIZACIJI')
            and   type = 'U')
   drop table AKT_O_ORGANIZACIJI
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('ARTIKLI_I_PRIMJERCI')
            and   name  = 'POSJEDUJE_FK'
            and   indid > 0
            and   indid < 255)
   drop index ARTIKLI_I_PRIMJERCI.POSJEDUJE_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('ARTIKLI_I_PRIMJERCI')
            and   name  = 'SU_PRIMJERCI_FK'
            and   indid > 0
            and   indid < 255)
   drop index ARTIKLI_I_PRIMJERCI.SU_PRIMJERCI_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('ARTIKLI_I_PRIMJERCI')
            and   type = 'U')
   drop table ARTIKLI_I_PRIMJERCI
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('ARTIKLI_NA_RAZMJENI')
            and   name  = 'SA_KIM_SE_RAZMJENJUJU_FK'
            and   indid > 0
            and   indid < 255)
   drop index ARTIKLI_NA_RAZMJENI.SA_KIM_SE_RAZMJENJUJU_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('ARTIKLI_NA_RAZMJENI')
            and   name  = 'KOJI_ARTIKLI_FK'
            and   indid > 0
            and   indid < 255)
   drop index ARTIKLI_NA_RAZMJENI.KOJI_ARTIKLI_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('ARTIKLI_NA_RAZMJENI')
            and   type = 'U')
   drop table ARTIKLI_NA_RAZMJENI
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('CJENOVNIK')
            and   name  = 'KOJE_PRAVNO_LICE_FK'
            and   indid > 0
            and   indid < 255)
   drop index CJENOVNIK.KOJE_PRAVNO_LICE_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('CJENOVNIK')
            and   name  = 'KOJE_ARTIKLE_FK'
            and   indid > 0
            and   indid < 255)
   drop index CJENOVNIK.KOJE_ARTIKLE_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('CJENOVNIK')
            and   name  = 'KOJI_TIP_CLANARINE_FK'
            and   indid > 0
            and   indid < 255)
   drop index CJENOVNIK.KOJI_TIP_CLANARINE_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('CJENOVNIK')
            and   name  = 'KOJE_USLUGE_FK'
            and   indid > 0
            and   indid < 255)
   drop index CJENOVNIK.KOJE_USLUGE_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('CJENOVNIK')
            and   type = 'U')
   drop table CJENOVNIK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('CLANSKA_KARTA')
            and   name  = 'TIPICAZIJA_CLANARINA_FK'
            and   indid > 0
            and   indid < 255)
   drop index CLANSKA_KARTA.TIPICAZIJA_CLANARINA_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('CLANSKA_KARTA')
            and   name  = 'IMAJU_CLANSKU_KATRU_FK'
            and   indid > 0
            and   indid < 255)
   drop index CLANSKA_KARTA.IMAJU_CLANSKU_KATRU_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('CLANSKA_KARTA')
            and   name  = 'CIJI_CU_KLIJENTI_FK'
            and   indid > 0
            and   indid < 255)
   drop index CLANSKA_KARTA.CIJI_CU_KLIJENTI_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('CLANSKA_KARTA')
            and   type = 'U')
   drop table CLANSKA_KARTA
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('DJELATNOST')
            and   name  = 'DJELATNOST_FK'
            and   indid > 0
            and   indid < 255)
   drop index DJELATNOST.DJELATNOST_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('DJELATNOST')
            and   name  = 'DJELATNOST2_FK'
            and   indid > 0
            and   indid < 255)
   drop index DJELATNOST.DJELATNOST2_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('DJELATNOST')
            and   type = 'U')
   drop table DJELATNOST
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('DRZAVA')
            and   name  = 'GLAVNI_GRAD_FK'
            and   indid > 0
            and   indid < 255)
   drop index DRZAVA.GLAVNI_GRAD_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('DRZAVA')
            and   name  = 'PRAVNI_NADSLEDNIK_FK'
            and   indid > 0
            and   indid < 255)
   drop index DRZAVA.PRAVNI_NADSLEDNIK_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('DRZAVA')
            and   type = 'U')
   drop table DRZAVA
go

if exists (select 1
            from  sysobjects
           where  id = object_id('KLIJENTI')
            and   type = 'U')
   drop table KLIJENTI
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('MJESTA_U_DRZAVI')
            and   name  = 'NALAZI_SE_U_DRZAVI_FK'
            and   indid > 0
            and   indid < 255)
   drop index MJESTA_U_DRZAVI.NALAZI_SE_U_DRZAVI_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('MJESTA_U_DRZAVI')
            and   name  = 'SADRZI_MJESTA_FK'
            and   indid > 0
            and   indid < 255)
   drop index MJESTA_U_DRZAVI.SADRZI_MJESTA_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('MJESTA_U_DRZAVI')
            and   type = 'U')
   drop table MJESTA_U_DRZAVI
go

if exists (select 1
            from  sysobjects
           where  id = object_id('NASELJENO_MJESTO')
            and   type = 'U')
   drop table NASELJENO_MJESTO
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('NASLOVI_I_OPIS')
            and   name  = 'TIPIZACIJA_ARTIKALA__KNJIGE_CD_COMP__FK'
            and   indid > 0
            and   indid < 255)
   drop index NASLOVI_I_OPIS.TIPIZACIJA_ARTIKALA__KNJIGE_CD_COMP__FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('NASLOVI_I_OPIS')
            and   type = 'U')
   drop table NASLOVI_I_OPIS
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('OBAVLJENE_USLUGE')
            and   name  = 'KO_ZAHTJEVA_USLUGU_FK'
            and   indid > 0
            and   indid < 255)
   drop index OBAVLJENE_USLUGE.KO_ZAHTJEVA_USLUGU_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('OBAVLJENE_USLUGE')
            and   name  = 'SA_KOJIM_ARTIKLIMA_FK'
            and   indid > 0
            and   indid < 255)
   drop index OBAVLJENE_USLUGE.SA_KOJIM_ARTIKLIMA_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('OBAVLJENE_USLUGE')
            and   name  = 'TIPIZACIJA_USLUGA_FK'
            and   indid > 0
            and   indid < 255)
   drop index OBAVLJENE_USLUGE.TIPIZACIJA_USLUGA_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('OBAVLJENE_USLUGE')
            and   type = 'U')
   drop table OBAVLJENE_USLUGE
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('OPSTINE')
            and   name  = 'SEDISTE_OPSTINE_FK'
            and   indid > 0
            and   indid < 255)
   drop index OPSTINE.SEDISTE_OPSTINE_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('OPSTINE')
            and   name  = 'LOKALNA_SAMOUPRAVA_FK'
            and   indid > 0
            and   indid < 255)
   drop index OPSTINE.LOKALNA_SAMOUPRAVA_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('OPSTINE')
            and   type = 'U')
   drop table OPSTINE
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('ORGANIZACIJA')
            and   name  = 'ORGANIZACIJA_FK'
            and   indid > 0
            and   indid < 255)
   drop index ORGANIZACIJA.ORGANIZACIJA_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('ORGANIZACIJA')
            and   name  = 'ORGANIZACIJA2_FK'
            and   indid > 0
            and   indid < 255)
   drop index ORGANIZACIJA.ORGANIZACIJA2_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('ORGANIZACIJA')
            and   type = 'U')
   drop table ORGANIZACIJA
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('ORGANIZACIONA_JEDINICA')
            and   name  = 'SEDISTE_JEDINICE_FK'
            and   indid > 0
            and   indid < 255)
   drop index ORGANIZACIONA_JEDINICA.SEDISTE_JEDINICE_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('ORGANIZACIONA_JEDINICA')
            and   name  = 'ORGANIZACIONA_JEDINICA_FK'
            and   indid > 0
            and   indid < 255)
   drop index ORGANIZACIONA_JEDINICA.ORGANIZACIONA_JEDINICA_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('ORGANIZACIONA_JEDINICA')
            and   type = 'U')
   drop table ORGANIZACIONA_JEDINICA
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('OSTVARENE_SARADNJE')
            and   name  = 'TIPIZACIJA_SARADNIKA_FK'
            and   indid > 0
            and   indid < 255)
   drop index OSTVARENE_SARADNJE.TIPIZACIJA_SARADNIKA_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('OSTVARENE_SARADNJE')
            and   name  = 'KOJA_MULTITEKA_FK'
            and   indid > 0
            and   indid < 255)
   drop index OSTVARENE_SARADNJE.KOJA_MULTITEKA_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('OSTVARENE_SARADNJE')
            and   name  = 'KOJI_PARTNERI_FK'
            and   indid > 0
            and   indid < 255)
   drop index OSTVARENE_SARADNJE.KOJI_PARTNERI_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('OSTVARENE_SARADNJE')
            and   type = 'U')
   drop table OSTVARENE_SARADNJE
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('PODACI_ZA_LOGOVANJE')
            and   name  = 'KORISNICI_SISTEMA__ILI_ZAPOSLENI_FK'
            and   indid > 0
            and   indid < 255)
   drop index PODACI_ZA_LOGOVANJE.KORISNICI_SISTEMA__ILI_ZAPOSLENI_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('PODACI_ZA_LOGOVANJE')
            and   name  = 'TIPIZACIJA_KORISNIKA_SISTEMA_FK'
            and   indid > 0
            and   indid < 255)
   drop index PODACI_ZA_LOGOVANJE.TIPIZACIJA_KORISNIKA_SISTEMA_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('PODACI_ZA_LOGOVANJE')
            and   name  = 'KORISNICI_SISTEMA__ILI_KORISNICI_FK'
            and   indid > 0
            and   indid < 255)
   drop index PODACI_ZA_LOGOVANJE.KORISNICI_SISTEMA__ILI_KORISNICI_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('PODACI_ZA_LOGOVANJE')
            and   type = 'U')
   drop table PODACI_ZA_LOGOVANJE
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('POTREBA_ZA')
            and   name  = 'KOJIH_ARTIKALA_JE_POTREBNO_JOS_FK'
            and   indid > 0
            and   indid < 255)
   drop index POTREBA_ZA.KOJIH_ARTIKALA_JE_POTREBNO_JOS_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('POTREBA_ZA')
            and   name  = 'TIPIZACIJA_PROIZVODNJE_FK'
            and   indid > 0
            and   indid < 255)
   drop index POTREBA_ZA.TIPIZACIJA_PROIZVODNJE_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('POTREBA_ZA')
            and   name  = 'POTREBA_ZA_KOPIRANJEM_STAMPANJEM_FK'
            and   indid > 0
            and   indid < 255)
   drop index POTREBA_ZA.POTREBA_ZA_KOPIRANJEM_STAMPANJEM_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('POTREBA_ZA')
            and   type = 'U')
   drop table POTREBA_ZA
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('PRAVNO_LICE')
            and   name  = 'PRAVNI_NASLEDNIK_FK'
            and   indid > 0
            and   indid < 255)
   drop index PRAVNO_LICE.PRAVNI_NASLEDNIK_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('PRAVNO_LICE')
            and   name  = 'SEDISTE_PRAVNOG_LICA_FK'
            and   indid > 0
            and   indid < 255)
   drop index PRAVNO_LICE.SEDISTE_PRAVNOG_LICA_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('PRAVNO_LICE')
            and   name  = 'REGISTROVANI_FK'
            and   indid > 0
            and   indid < 255)
   drop index PRAVNO_LICE.REGISTROVANI_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('PRAVNO_LICE')
            and   type = 'U')
   drop table PRAVNO_LICE
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('PROMOCIJE')
            and   name  = 'VRSTE_PROMOCIJE_FK'
            and   indid > 0
            and   indid < 255)
   drop index PROMOCIJE.VRSTE_PROMOCIJE_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('PROMOCIJE')
            and   name  = 'SE_PROMOVISE_FK'
            and   indid > 0
            and   indid < 255)
   drop index PROMOCIJE.SE_PROMOVISE_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('PROMOCIJE')
            and   type = 'U')
   drop table PROMOCIJE
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('RASPORED_RADNIH_MJESTA')
            and   name  = 'R_MJESTO_FK'
            and   indid > 0
            and   indid < 255)
   drop index RASPORED_RADNIH_MJESTA.R_MJESTO_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('RASPORED_RADNIH_MJESTA')
            and   name  = 'RADI_FK'
            and   indid > 0
            and   indid < 255)
   drop index RASPORED_RADNIH_MJESTA.RADI_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('RASPORED_RADNIH_MJESTA')
            and   type = 'U')
   drop table RASPORED_RADNIH_MJESTA
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('REGION')
            and   name  = 'SEDISTE_REGIONA_FK'
            and   indid > 0
            and   indid < 255)
   drop index REGION.SEDISTE_REGIONA_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('REGION')
            and   name  = 'PRIPADA_DRZAVI_FK'
            and   indid > 0
            and   indid < 255)
   drop index REGION.PRIPADA_DRZAVI_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('REGION')
            and   name  = 'TIPIZACIJA_REGIONA_FK'
            and   indid > 0
            and   indid < 255)
   drop index REGION.TIPIZACIJA_REGIONA_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('REGION')
            and   type = 'U')
   drop table REGION
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('REGIONALNA_DRZAVA')
            and   name  = 'REGION_U_DRZAVI_FK'
            and   indid > 0
            and   indid < 255)
   drop index REGIONALNA_DRZAVA.REGION_U_DRZAVI_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('REGIONALNA_DRZAVA')
            and   name  = 'REGIONI_DRZAVE_FK'
            and   indid > 0
            and   indid < 255)
   drop index REGIONALNA_DRZAVA.REGIONI_DRZAVE_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('REGIONALNA_DRZAVA')
            and   type = 'U')
   drop table REGIONALNA_DRZAVA
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('REGISTAR_DJELATNOSTI')
            and   name  = 'ZA_DRZAVU_FK'
            and   indid > 0
            and   indid < 255)
   drop index REGISTAR_DJELATNOSTI.ZA_DRZAVU_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('REGISTAR_DJELATNOSTI')
            and   type = 'U')
   drop table REGISTAR_DJELATNOSTI
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('REGISTAR_ZAPOSLENIH')
            and   name  = 'ZAPOSLENI_FK'
            and   indid > 0
            and   indid < 255)
   drop index REGISTAR_ZAPOSLENIH.ZAPOSLENI_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('REGISTAR_ZAPOSLENIH')
            and   type = 'U')
   drop table REGISTAR_ZAPOSLENIH
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('SISTEMATIZACIJA_RADNIH_MJESTA')
            and   name  = 'RADNA_MJESTA_FK'
            and   indid > 0
            and   indid < 255)
   drop index SISTEMATIZACIJA_RADNIH_MJESTA.RADNA_MJESTA_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('SISTEMATIZACIJA_RADNIH_MJESTA')
            and   type = 'U')
   drop table SISTEMATIZACIJA_RADNIH_MJESTA
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('SLOZENA_DRZAVA')
            and   name  = 'CLANICA_FK'
            and   indid > 0
            and   indid < 255)
   drop index SLOZENA_DRZAVA.CLANICA_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('SLOZENA_DRZAVA')
            and   name  = 'SLOZENA_FK'
            and   indid > 0
            and   indid < 255)
   drop index SLOZENA_DRZAVA.SLOZENA_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('SLOZENA_DRZAVA')
            and   type = 'U')
   drop table SLOZENA_DRZAVA
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('STRUKTURA_NASELJA')
            and   name  = 'STRUKTURA_NASELJA_FK'
            and   indid > 0
            and   indid < 255)
   drop index STRUKTURA_NASELJA.STRUKTURA_NASELJA_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('STRUKTURA_NASELJA')
            and   name  = 'STRUKTURA_NASELJA2_FK'
            and   indid > 0
            and   indid < 255)
   drop index STRUKTURA_NASELJA.STRUKTURA_NASELJA2_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('STRUKTURA_NASELJA')
            and   type = 'U')
   drop table STRUKTURA_NASELJA
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('STRUKTURA_REGIONA')
            and   name  = 'STRUKTURA_REGIONA_FK'
            and   indid > 0
            and   indid < 255)
   drop index STRUKTURA_REGIONA.STRUKTURA_REGIONA_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('STRUKTURA_REGIONA')
            and   name  = 'STRUKTURA_REGIONA2_FK'
            and   indid > 0
            and   indid < 255)
   drop index STRUKTURA_REGIONA.STRUKTURA_REGIONA2_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('STRUKTURA_REGIONA')
            and   type = 'U')
   drop table STRUKTURA_REGIONA
go

if exists (select 1
            from  sysobjects
           where  id = object_id('TIP_ARTIKLIA')
            and   type = 'U')
   drop table TIP_ARTIKLIA
go

if exists (select 1
            from  sysobjects
           where  id = object_id('TIP_CLANARINE')
            and   type = 'U')
   drop table TIP_CLANARINE
go

if exists (select 1
            from  sysobjects
           where  id = object_id('TIP_KORISNIKA_SISTEMA')
            and   type = 'U')
   drop table TIP_KORISNIKA_SISTEMA
go

if exists (select 1
            from  sysobjects
           where  id = object_id('TIP_PROIZVODNJE')
            and   type = 'U')
   drop table TIP_PROIZVODNJE
go

if exists (select 1
            from  sysobjects
           where  id = object_id('TIP_PROMOCIJE')
            and   type = 'U')
   drop table TIP_PROMOCIJE
go

if exists (select 1
            from  sysobjects
           where  id = object_id('TIP_REGIONA')
            and   type = 'U')
   drop table TIP_REGIONA
go

if exists (select 1
            from  sysobjects
           where  id = object_id('TIP_SARADNJE')
            and   type = 'U')
   drop table TIP_SARADNJE
go

if exists (select 1
            from  sysobjects
           where  id = object_id('TIP_USLUGE')
            and   type = 'U')
   drop table TIP_USLUGE
go

/*==============================================================*/
/* Table: AKT_O_ORGANIZACIJI                                    */
/*==============================================================*/
create table AKT_O_ORGANIZACIJI (
   AO_BROJ_AKTA         numeric(4)           not null,
   DRZAVA_U_KOJOJ_SE_NALAZI char(3)              not null,
   ID_PRAVNOG_LICA      int                  not null,
   OJ_IDENTIFIKACIJA    numeric(4)           not null,
   OJ_DATDON            date                 not null,
   OJ_VAZI_DO           date                 null,
   constraint PK_AKT_O_ORGANIZACIJI primary key nonclustered (DRZAVA_U_KOJOJ_SE_NALAZI, ID_PRAVNOG_LICA, OJ_IDENTIFIKACIJA, AO_BROJ_AKTA)
)
go

/*==============================================================*/
/* Index: AKT_O_ORGANIZACIJI_FK                                 */
/*==============================================================*/
create index AKT_O_ORGANIZACIJI_FK on AKT_O_ORGANIZACIJI (
DRZAVA_U_KOJOJ_SE_NALAZI ASC,
ID_PRAVNOG_LICA ASC,
OJ_IDENTIFIKACIJA ASC
)
go

/*==============================================================*/
/* Table: ARTIKLI_I_PRIMJERCI                                   */
/*==============================================================*/
create table ARTIKLI_I_PRIMJERCI (
   ID_PRIMJERKA         int                  not null,
   DRZAVA_U_KOJOJ_SE_NALAZI char(3)              not null,
   ID_PRAVNOG_LICA      int                  not null,
   ID_TIPA_ARTIKLA      char(1)              not null,
   ID_NASLOVA           int                  not null,
   DA_LI_JE_U_ISPRAVNOM_STANJU bit                  not null default 1
      constraint CKC_DA_LI_JE_U_ISPRAV_ARTIKLI_ check (DA_LI_JE_U_ISPRAVNOM_STANJU in (1,0)),
   DA_LI_JE_DOSTUPAN    bit                  not null default 1
      constraint CKC_DA_LI_JE_DOSTUPAN_ARTIKLI_ check (DA_LI_JE_DOSTUPAN in (1,0)),
   OPIS_OSTECENJA       varchar(60)          null,
   constraint PK_ARTIKLI_I_PRIMJERCI primary key nonclustered (DRZAVA_U_KOJOJ_SE_NALAZI, ID_PRAVNOG_LICA, ID_TIPA_ARTIKLA, ID_NASLOVA, ID_PRIMJERKA)
)
go

/*==============================================================*/
/* Index: SU_PRIMJERCI_FK                                       */
/*==============================================================*/
create index SU_PRIMJERCI_FK on ARTIKLI_I_PRIMJERCI (
ID_TIPA_ARTIKLA ASC,
ID_NASLOVA ASC
)
go

/*==============================================================*/
/* Index: POSJEDUJE_FK                                          */
/*==============================================================*/
create index POSJEDUJE_FK on ARTIKLI_I_PRIMJERCI (
DRZAVA_U_KOJOJ_SE_NALAZI ASC,
ID_PRAVNOG_LICA ASC
)
go

/*==============================================================*/
/* Table: ARTIKLI_NA_RAZMJENI                                   */
/*==============================================================*/
create table ARTIKLI_NA_RAZMJENI (
   ID_SARADNJE          numeric(2)           not null,
   DRZAVA_MULTITEKA     char(3)              not null,
   ID_P_LICA_MULTITEKA  int                  not null,
   DRZAVA_POSLOVNI_PARTNER char(3)              not null,
   ID_POSLOVNOG_PARTNERA int                  not null,
   ID_ARTIKLA_NA_RAZMJENI numeric(2)           not null,
   DRZAVA_GDJE_JE_ARTIKAL char(3)              not null,
   ID_P_LICA_ARTIKLA    int                  not null,
   ID_TIPA_ARTIKLA      char(1)              not null,
   ID_NASLOVA           int                  not null,
   ID_PRIMJERKA         int                  not null,
   DATUM_OD             date                 not null,
   DATUM_DO             date                 null,
   RAZLOG               varchar(100)         null,
   constraint PK_ARTIKLI_NA_RAZMJENI primary key nonclustered (DRZAVA_MULTITEKA, ID_P_LICA_MULTITEKA, DRZAVA_POSLOVNI_PARTNER, ID_POSLOVNOG_PARTNERA, ID_SARADNJE, ID_ARTIKLA_NA_RAZMJENI)
)
go

/*==============================================================*/
/* Index: KOJI_ARTIKLI_FK                                       */
/*==============================================================*/
create index KOJI_ARTIKLI_FK on ARTIKLI_NA_RAZMJENI (
DRZAVA_GDJE_JE_ARTIKAL ASC,
ID_P_LICA_ARTIKLA ASC,
ID_TIPA_ARTIKLA ASC,
ID_NASLOVA ASC,
ID_PRIMJERKA ASC
)
go

/*==============================================================*/
/* Index: SA_KIM_SE_RAZMJENJUJU_FK                              */
/*==============================================================*/
create index SA_KIM_SE_RAZMJENJUJU_FK on ARTIKLI_NA_RAZMJENI (
DRZAVA_MULTITEKA ASC,
ID_P_LICA_MULTITEKA ASC,
DRZAVA_POSLOVNI_PARTNER ASC,
ID_POSLOVNOG_PARTNERA ASC,
ID_SARADNJE ASC
)
go

/*==============================================================*/
/* Table: CJENOVNIK                                             */
/*==============================================================*/
create table CJENOVNIK (
   POSLOVNA_GODINA      numeric(4)           not null,
   DRZAVA_U_KOJOJ_SE_NALAZI char(3)              not null,
   ID_PRAVNOG_LICA      int                  not null,
   ID_TIPA_CLANARINE    char(3)              not null,
   ID_TIPA_USLUGE       char(1)              not null,
   ID_TIPA_ARTIKLA      char(1)              not null,
   ID_NASLOVA           int                  not null,
   ID_CJENE             int                  not null,
   CJENA                numeric(5)           not null,
   POPUST               numeric(2)           null,
   TRAZENI_AVANAS       numeric(4)           null,
   DATUM_POCETKA_VAZENJA date                 null,
   constraint PK_CJENOVNIK primary key nonclustered (DRZAVA_U_KOJOJ_SE_NALAZI, ID_PRAVNOG_LICA, ID_TIPA_ARTIKLA, ID_NASLOVA, ID_TIPA_CLANARINE, ID_TIPA_USLUGE, ID_CJENE, POSLOVNA_GODINA)
)
go

/*==============================================================*/
/* Index: KOJE_USLUGE_FK                                        */
/*==============================================================*/
create index KOJE_USLUGE_FK on CJENOVNIK (
ID_TIPA_USLUGE ASC
)
go

/*==============================================================*/
/* Index: KOJI_TIP_CLANARINE_FK                                 */
/*==============================================================*/
create index KOJI_TIP_CLANARINE_FK on CJENOVNIK (
ID_TIPA_CLANARINE ASC
)
go

/*==============================================================*/
/* Index: KOJE_ARTIKLE_FK                                       */
/*==============================================================*/
create index KOJE_ARTIKLE_FK on CJENOVNIK (
ID_TIPA_ARTIKLA ASC,
ID_NASLOVA ASC
)
go

/*==============================================================*/
/* Index: KOJE_PRAVNO_LICE_FK                                   */
/*==============================================================*/
create index KOJE_PRAVNO_LICE_FK on CJENOVNIK (
DRZAVA_U_KOJOJ_SE_NALAZI ASC,
ID_PRAVNOG_LICA ASC
)
go

/*==============================================================*/
/* Table: CLANSKA_KARTA                                         */
/*==============================================================*/
create table CLANSKA_KARTA (
   ID_CLANSKE_KARTE     numeric(2)           not null,
   DRZAVA_U_KOJOJ_SE_P_LICE_NALAZI char(3)              not null,
   ID_PRAVNOG_LICA      int                  not null,
   ID_KLIJENTA          int                  not null,
   ID_TIPA_CLANARINE    char(3)              not null,
   VAZI_OD              date                 not null,
   VAZI_DO              date                 null,
   DA_LI_JE_PLACENA_CLANARINA bit                  not null default 0
      constraint CKC_DA_LI_JE_PLACENA__CLANSKA_ check (DA_LI_JE_PLACENA_CLANARINA in (1,0)),
   constraint PK_CLANSKA_KARTA primary key nonclustered (DRZAVA_U_KOJOJ_SE_P_LICE_NALAZI, ID_PRAVNOG_LICA, ID_KLIJENTA, ID_CLANSKE_KARTE)
)
go

/*==============================================================*/
/* Index: CIJI_CU_KLIJENTI_FK                                   */
/*==============================================================*/
create index CIJI_CU_KLIJENTI_FK on CLANSKA_KARTA (
DRZAVA_U_KOJOJ_SE_P_LICE_NALAZI ASC,
ID_PRAVNOG_LICA ASC
)
go

/*==============================================================*/
/* Index: IMAJU_CLANSKU_KATRU_FK                                */
/*==============================================================*/
create index IMAJU_CLANSKU_KATRU_FK on CLANSKA_KARTA (
ID_KLIJENTA ASC
)
go

/*==============================================================*/
/* Index: TIPICAZIJA_CLANARINA_FK                               */
/*==============================================================*/
create index TIPICAZIJA_CLANARINA_FK on CLANSKA_KARTA (
ID_TIPA_CLANARINE ASC
)
go

/*==============================================================*/
/* Table: DJELATNOST                                            */
/*==============================================================*/
create table DJELATNOST (
   DRZAVA_U_KOJOJ_SE_NALAZI char(3)              not null,
   ID_PRAVNOG_LICA      int                  not null,
   RD_IDENTIFIKATOR     char(2)              not null,
   constraint PK_DJELATNOST primary key nonclustered (DRZAVA_U_KOJOJ_SE_NALAZI, ID_PRAVNOG_LICA, RD_IDENTIFIKATOR)
)
go

/*==============================================================*/
/* Index: DJELATNOST2_FK                                        */
/*==============================================================*/
create index DJELATNOST2_FK on DJELATNOST (
RD_IDENTIFIKATOR ASC
)
go

/*==============================================================*/
/* Index: DJELATNOST_FK                                         */
/*==============================================================*/
create index DJELATNOST_FK on DJELATNOST (
DRZAVA_U_KOJOJ_SE_NALAZI ASC,
ID_PRAVNOG_LICA ASC
)
go

/*==============================================================*/
/* Table: DRZAVA                                                */
/*==============================================================*/
create table DRZAVA (
   OZNAKA_DRZAVE        char(3)              not null,
   DR_NAZIV             varchar(80)          not null,
   NM_IDENTIFIKATOR     int                  null,
   DRZAVA_PRAVNI_NASLJEDNIK char(3)              null,
   constraint PK_DRZAVA primary key nonclustered (OZNAKA_DRZAVE)
)
go

/*==============================================================*/
/* Index: PRAVNI_NADSLEDNIK_FK                                  */
/*==============================================================*/
create index PRAVNI_NADSLEDNIK_FK on DRZAVA (
DRZAVA_PRAVNI_NASLJEDNIK ASC
)
go

/*==============================================================*/
/* Index: GLAVNI_GRAD_FK                                        */
/*==============================================================*/
create index GLAVNI_GRAD_FK on DRZAVA (
NM_IDENTIFIKATOR ASC
)
go

/*==============================================================*/
/* Table: KLIJENTI                                              */
/*==============================================================*/
create table KLIJENTI (
   ID_KLIJENTA          int                  not null,
   IME                  varchar(30)          not null,
   PREZIME              varchar(30)          not null,
   IME_1__RODITELJA     varchar(30)          null,
   DATUM_RODJENJA       date                 not null,
   BROJ_TELEFONA        varchar(20)          not null,
   BROJ_LICNE_KARTE     varchar(10)          null,
   E_MAIL               varchar(30)          null,
   constraint PK_KLIJENTI primary key nonclustered (ID_KLIJENTA)
)
go

/*==============================================================*/
/* Table: MJESTA_U_DRZAVI                                       */
/*==============================================================*/
create table MJESTA_U_DRZAVI (
   OZNAKA_DRZAVE        char(3)              not null,
   NM_IDENTIFIKATOR     int                  not null,
   NMD_OD               date                 not null,
   NMD_DO               date                 null,
   constraint PK_MJESTA_U_DRZAVI primary key nonclustered (NM_IDENTIFIKATOR, OZNAKA_DRZAVE, NMD_OD)
)
go

if exists (select 1 from  sys.extended_properties
           where major_id = object_id('MJESTA_U_DRZAVI') and minor_id = 0)
begin 
   declare @CurrentUser sysname 
select @CurrentUser = user_name() 
execute sp_dropextendedproperty 'MS_Description',  
   'user', @CurrentUser, 'table', 'MJESTA_U_DRZAVI' 
 
end 


select @CurrentUser = user_name() 
execute sp_addextendedproperty 'MS_Description',  
   'Ukljuciti temporalnost!!', 
   'user', @CurrentUser, 'table', 'MJESTA_U_DRZAVI'
go

/*==============================================================*/
/* Index: SADRZI_MJESTA_FK                                      */
/*==============================================================*/
create index SADRZI_MJESTA_FK on MJESTA_U_DRZAVI (
OZNAKA_DRZAVE ASC
)
go

/*==============================================================*/
/* Index: NALAZI_SE_U_DRZAVI_FK                                 */
/*==============================================================*/
create index NALAZI_SE_U_DRZAVI_FK on MJESTA_U_DRZAVI (
NM_IDENTIFIKATOR ASC
)
go

/*==============================================================*/
/* Table: NASELJENO_MJESTO                                      */
/*==============================================================*/
create table NASELJENO_MJESTO (
   NM_IDENTIFIKATOR     int                  not null,
   NM_NAZIV             varchar(40)          not null,
   NM_PTT_OZNAKA        varchar(20)          not null,
   constraint PK_NASELJENO_MJESTO primary key nonclustered (NM_IDENTIFIKATOR)
)
go

/*==============================================================*/
/* Table: NASLOVI_I_OPIS                                        */
/*==============================================================*/
create table NASLOVI_I_OPIS (
   ID_NASLOVA           int                  not null,
   ID_TIPA_ARTIKLA      char(1)              not null,
   NAZIV                varchar(30)          not null,
   AUTOR                varchar(60)          null,
   JEZIK                varchar(20)          null,
   GODINA_IZDANJA       numeric(4)           null,
   IZDAVAC              varchar(50)          null,
   PROIZVODJAC          varchar(30)          null,
   OSOBINE              varchar(100)         null,
   BROJ_PJESAMA         numeric(4)           null,
   constraint PK_NASLOVI_I_OPIS primary key nonclustered (ID_TIPA_ARTIKLA, ID_NASLOVA)
)
go

/*==============================================================*/
/* Index: TIPIZACIJA_ARTIKALA__KNJIGE_CD_COMP__FK               */
/*==============================================================*/
create index TIPIZACIJA_ARTIKALA__KNJIGE_CD_COMP__FK on NASLOVI_I_OPIS (
ID_TIPA_ARTIKLA ASC
)
go

/*==============================================================*/
/* Table: OBAVLJENE_USLUGE                                      */
/*==============================================================*/
create table OBAVLJENE_USLUGE (
   ID_USLUGE            int                  not null,
   ID_TIPA_USLUGE       char(1)              not null,
   DRZAVA_U_KOJOJ_SE_P_LICE_NALAZI char(3)              not null,
   ID_PRAVNOG_LICA      int                  not null,
   ID_CLANSKE_KARTE     numeric(2)           not null,
   ID_KLIJENTA          int                  not null,
   ID_TIPA_ARTIKLA      char(1)              not null,
   ID_NASLOVA           int                  not null,
   ID_PRIMJERKA         int                  not null,
   DATUM_POCETKA        date                 not null,
   NA_KOLIKO_DANA       numeric(2)           null,
   NA_KOLIKO_SATI       numeric(3)           null,
   DATUM_ZAVRSETKA      date                 null,
   DATUM_OTKUPA         date                 null,
   RAZLOG_OTKUPA        varchar(50)          null,
   constraint PK_OBAVLJENE_USLUGE primary key nonclustered (DRZAVA_U_KOJOJ_SE_P_LICE_NALAZI, ID_KLIJENTA, ID_CLANSKE_KARTE, ID_TIPA_USLUGE, ID_USLUGE, ID_PRAVNOG_LICA)
)
go

/*==============================================================*/
/* Index: TIPIZACIJA_USLUGA_FK                                  */
/*==============================================================*/
create index TIPIZACIJA_USLUGA_FK on OBAVLJENE_USLUGE (
ID_TIPA_USLUGE ASC
)
go

/*==============================================================*/
/* Index: SA_KOJIM_ARTIKLIMA_FK                                 */
/*==============================================================*/
create index SA_KOJIM_ARTIKLIMA_FK on OBAVLJENE_USLUGE (
DRZAVA_U_KOJOJ_SE_P_LICE_NALAZI ASC,
ID_PRAVNOG_LICA ASC,
ID_TIPA_ARTIKLA ASC,
ID_NASLOVA ASC,
ID_PRIMJERKA ASC
)
go

/*==============================================================*/
/* Index: KO_ZAHTJEVA_USLUGU_FK                                 */
/*==============================================================*/
create index KO_ZAHTJEVA_USLUGU_FK on OBAVLJENE_USLUGE (
DRZAVA_U_KOJOJ_SE_P_LICE_NALAZI ASC,
ID_PRAVNOG_LICA ASC,
ID_KLIJENTA ASC,
ID_CLANSKE_KARTE ASC
)
go

/*==============================================================*/
/* Table: OPSTINE                                               */
/*==============================================================*/
create table OPSTINE (
   OP_OZNAKA            char(3)              not null,
   OP_NAZIV             varchar(60)          not null,
   DRZAVA_U_KOJOJ_SE_NALAZI char(3)              not null,
   NM_IDENTIFIKATOR     int                  null,
   constraint PK_OPSTINE primary key nonclustered (DRZAVA_U_KOJOJ_SE_NALAZI, OP_OZNAKA)
)
go

/*==============================================================*/
/* Index: LOKALNA_SAMOUPRAVA_FK                                 */
/*==============================================================*/
create index LOKALNA_SAMOUPRAVA_FK on OPSTINE (
DRZAVA_U_KOJOJ_SE_NALAZI ASC
)
go

/*==============================================================*/
/* Index: SEDISTE_OPSTINE_FK                                    */
/*==============================================================*/
create index SEDISTE_OPSTINE_FK on OPSTINE (
NM_IDENTIFIKATOR ASC
)
go

/*==============================================================*/
/* Table: ORGANIZACIJA                                          */
/*==============================================================*/
create table ORGANIZACIJA (
   AO_BROJ_AKTA         numeric(4)           not null,
   OZNAKA_DRZAVE        char(3)              not null,
   ID_PRAVNOG_LICA2     int                  not null,
   OJ_IDENTIFIKACIJA    numeric(4)           not null,
   DRZAVA_U_KOJOJ_SE_NALAZI char(3)              not null,
   ID_PRAVNOG_LICA      int                  not null,
   AKT_OJ_IDENTIFIKACIJA numeric(4)           not null,
   constraint PK_ORGANIZACIJA primary key nonclustered (DRZAVA_U_KOJOJ_SE_NALAZI, ID_PRAVNOG_LICA, AKT_OJ_IDENTIFIKACIJA, AO_BROJ_AKTA, OZNAKA_DRZAVE, ID_PRAVNOG_LICA2, OJ_IDENTIFIKACIJA)
)
go

/*==============================================================*/
/* Index: ORGANIZACIJA2_FK                                      */
/*==============================================================*/
create index ORGANIZACIJA2_FK on ORGANIZACIJA (
DRZAVA_U_KOJOJ_SE_NALAZI ASC,
ID_PRAVNOG_LICA ASC,
AKT_OJ_IDENTIFIKACIJA ASC
)
go

/*==============================================================*/
/* Index: ORGANIZACIJA_FK                                       */
/*==============================================================*/
create index ORGANIZACIJA_FK on ORGANIZACIJA (
DRZAVA_U_KOJOJ_SE_NALAZI ASC,
ID_PRAVNOG_LICA ASC,
AKT_OJ_IDENTIFIKACIJA ASC,
AO_BROJ_AKTA ASC
)
go

/*==============================================================*/
/* Table: ORGANIZACIONA_JEDINICA                                */
/*==============================================================*/
create table ORGANIZACIONA_JEDINICA (
   OJ_IDENTIFIKACIJA    numeric(4)           not null,
   OJ_NAZIV             varchar(60)          not null,
   ID_PRAVNOG_LICA      int                  not null,
   DRZAVA_U_KOJOJ_SE_NALAZI char(3)              not null,
   NM_IDENTIFIKATOR     int                  null,
   OJ_PRAVNOLICE        bit                  not null default 0
      constraint CKC_OJ_PRAVNOLICE_ORGANIZA check (OJ_PRAVNOLICE between 0 and 1 and OJ_PRAVNOLICE in (0,1)),
   constraint PK_ORGANIZACIONA_JEDINICA primary key nonclustered (DRZAVA_U_KOJOJ_SE_NALAZI, ID_PRAVNOG_LICA, OJ_IDENTIFIKACIJA)
)
go

/*==============================================================*/
/* Index: ORGANIZACIONA_JEDINICA_FK                             */
/*==============================================================*/
create index ORGANIZACIONA_JEDINICA_FK on ORGANIZACIONA_JEDINICA (
DRZAVA_U_KOJOJ_SE_NALAZI ASC,
ID_PRAVNOG_LICA ASC
)
go

/*==============================================================*/
/* Index: SEDISTE_JEDINICE_FK                                   */
/*==============================================================*/
create index SEDISTE_JEDINICE_FK on ORGANIZACIONA_JEDINICA (
NM_IDENTIFIKATOR ASC
)
go

/*==============================================================*/
/* Table: OSTVARENE_SARADNJE                                    */
/*==============================================================*/
create table OSTVARENE_SARADNJE (
   ID_SARADNJE          numeric(2)           not null,
   ID_TIPA_SARADNJE     char(1)              null,
   DRZAVA_MULTITEKA     char(3)              not null,
   ID_P_LICA_MULTITEKA  int                  not null,
   DRZAVA_POSLOVNI_PARTNER char(3)              not null,
   ID_POSLOVNOG_PARTNERA int                  not null,
   DATUM_POCETKA        date                 not null,
   DATUM_ZAVRSETKA      date                 null,
   VAZECA_SARADNJA      bit                  not null default 1
      constraint CKC_VAZECA_SARADNJA_OSTVAREN check (VAZECA_SARADNJA in (1,0)),
   OPIS                 varchar(50)          null,
   constraint PK_OSTVARENE_SARADNJE primary key nonclustered (DRZAVA_MULTITEKA, ID_P_LICA_MULTITEKA, DRZAVA_POSLOVNI_PARTNER, ID_POSLOVNOG_PARTNERA, ID_SARADNJE)
)
go

/*==============================================================*/
/* Index: KOJI_PARTNERI_FK                                      */
/*==============================================================*/
create index KOJI_PARTNERI_FK on OSTVARENE_SARADNJE (
DRZAVA_POSLOVNI_PARTNER ASC,
ID_POSLOVNOG_PARTNERA ASC
)
go

/*==============================================================*/
/* Index: KOJA_MULTITEKA_FK                                     */
/*==============================================================*/
create index KOJA_MULTITEKA_FK on OSTVARENE_SARADNJE (
DRZAVA_MULTITEKA ASC,
ID_P_LICA_MULTITEKA ASC
)
go

/*==============================================================*/
/* Index: TIPIZACIJA_SARADNIKA_FK                               */
/*==============================================================*/
create index TIPIZACIJA_SARADNIKA_FK on OSTVARENE_SARADNJE (
ID_TIPA_SARADNJE ASC
)
go

/*==============================================================*/
/* Table: PODACI_ZA_LOGOVANJE                                   */
/*==============================================================*/
create table PODACI_ZA_LOGOVANJE (
   ID_PODATAKA          numeric(2)           not null,
   ID_TIPA_KORISNIKA_SISTEM char(3)              not null,
   ID_KLIJENTA          int                  null,
   ID_ZAPOSLENOG        int                  null,
   ID_PRAVNOG_LICA_GDJE_JE_ZAPOSLEN int                  null,
   DRZAVA_U_KOJOJ_SE_P_LICE__NALAZI char(3)              null,
   KORISNICKO_IME       varchar(30)          not null,
   SIFRA                varchar(30)          not null,
   constraint PK_PODACI_ZA_LOGOVANJE primary key nonclustered (ID_TIPA_KORISNIKA_SISTEM, ID_PODATAKA)
)
go

/*==============================================================*/
/* Index: KORISNICI_SISTEMA__ILI_KORISNICI_FK                   */
/*==============================================================*/
create index KORISNICI_SISTEMA__ILI_KORISNICI_FK on PODACI_ZA_LOGOVANJE (
ID_KLIJENTA ASC
)
go

/*==============================================================*/
/* Index: TIPIZACIJA_KORISNIKA_SISTEMA_FK                       */
/*==============================================================*/
create index TIPIZACIJA_KORISNIKA_SISTEMA_FK on PODACI_ZA_LOGOVANJE (
ID_TIPA_KORISNIKA_SISTEM ASC
)
go

/*==============================================================*/
/* Index: KORISNICI_SISTEMA__ILI_ZAPOSLENI_FK                   */
/*==============================================================*/
create index KORISNICI_SISTEMA__ILI_ZAPOSLENI_FK on PODACI_ZA_LOGOVANJE (
DRZAVA_U_KOJOJ_SE_P_LICE__NALAZI ASC,
ID_PRAVNOG_LICA_GDJE_JE_ZAPOSLEN ASC,
ID_ZAPOSLENOG ASC
)
go

/*==============================================================*/
/* Table: POTREBA_ZA                                            */
/*==============================================================*/
create table POTREBA_ZA (
   ID_PROIZVODNJE       int                  not null,
   DRZAVA_U_KOJOJ_SE_NALAZI char(3)              not null,
   ID_PRAVNOG_LICA      int                  not null,
   ID_TIPA_PROIZVODNJE  char(1)              not null,
   ID_TIPA_ARTIKLA      char(1)              not null,
   ID_NASLOVA           int                  not null,
   KOLIKO_PRIMJERAKA    numeric(3)           not null,
   DATUM_POCETKA        date                 null,
   ODGOVORNA_OSOBA      varchar(60)          null,
   constraint PK_POTREBA_ZA primary key nonclustered (ID_TIPA_ARTIKLA, ID_NASLOVA, DRZAVA_U_KOJOJ_SE_NALAZI, ID_PRAVNOG_LICA, ID_PROIZVODNJE)
)
go

/*==============================================================*/
/* Index: POTREBA_ZA_KOPIRANJEM_STAMPANJEM_FK                   */
/*==============================================================*/
create index POTREBA_ZA_KOPIRANJEM_STAMPANJEM_FK on POTREBA_ZA (
DRZAVA_U_KOJOJ_SE_NALAZI ASC,
ID_PRAVNOG_LICA ASC
)
go

/*==============================================================*/
/* Index: TIPIZACIJA_PROIZVODNJE_FK                             */
/*==============================================================*/
create index TIPIZACIJA_PROIZVODNJE_FK on POTREBA_ZA (
ID_TIPA_PROIZVODNJE ASC
)
go

/*==============================================================*/
/* Index: KOJIH_ARTIKALA_JE_POTREBNO_JOS_FK                     */
/*==============================================================*/
create index KOJIH_ARTIKALA_JE_POTREBNO_JOS_FK on POTREBA_ZA (
ID_TIPA_ARTIKLA ASC,
ID_NASLOVA ASC
)
go

/*==============================================================*/
/* Table: PRAVNO_LICE                                           */
/*==============================================================*/
create table PRAVNO_LICE (
   ID_PRAVNOG_LICA      int                  not null,
   IPL_NAZIV            varchar(80)          not null,
   MATICNI_BROJ         varchar(15)          null,
   PIB                  varchar(20)          null,
   ADRESA               varchar(50)          null,
   DRZAVA_U_KOJOJ_SE_NALAZI char(3)              not null,
   E_MAIL               varchar(30)          null,
   TELEFON              varchar(20)          null,
   FAX                  varchar(20)          null,
   NM_IDENTIFIKATOR     int                  null,
   PRAVNI_NASLJENIK_PRAVNO_LICE int                  null,
   PRAVNI_NASLJEDNIK_DRZAVA char(3)              null,
   constraint PK_PRAVNO_LICE primary key nonclustered (DRZAVA_U_KOJOJ_SE_NALAZI, ID_PRAVNOG_LICA)
)
go

/*==============================================================*/
/* Index: REGISTROVANI_FK                                       */
/*==============================================================*/
create index REGISTROVANI_FK on PRAVNO_LICE (
DRZAVA_U_KOJOJ_SE_NALAZI ASC
)
go

/*==============================================================*/
/* Index: SEDISTE_PRAVNOG_LICA_FK                               */
/*==============================================================*/
create index SEDISTE_PRAVNOG_LICA_FK on PRAVNO_LICE (
NM_IDENTIFIKATOR ASC
)
go

/*==============================================================*/
/* Index: PRAVNI_NASLEDNIK_FK                                   */
/*==============================================================*/
create index PRAVNI_NASLEDNIK_FK on PRAVNO_LICE (
PRAVNI_NASLJEDNIK_DRZAVA ASC,
PRAVNI_NASLJENIK_PRAVNO_LICE ASC
)
go

/*==============================================================*/
/* Table: PROMOCIJE                                             */
/*==============================================================*/
create table PROMOCIJE (
   ID_PROMOCIJE         int                  not null,
   DRZAVA_U_KOJOJ_SE_NALAZI char(3)              not null,
   ID_PRAVNOG_LICA      int                  not null,
   ID_TIPA_PROMOCIJE    char(1)              not null,
   DATUM_ODRZAVANJA     date                 not null,
   ADRESA               varchar(50)          null,
   BROJ_PRISUTNIH_GOSTI numeric(4)           null,
   BROJ_PRIMJERAKA      numeric(5)           null,
   POTREBNO_RADNIKA     numeric(2)           null,
   UTROSENO_NOVCA       numeric(6)           null,
   constraint PK_PROMOCIJE primary key nonclustered (DRZAVA_U_KOJOJ_SE_NALAZI, ID_PRAVNOG_LICA, ID_PROMOCIJE)
)
go

/*==============================================================*/
/* Index: SE_PROMOVISE_FK                                       */
/*==============================================================*/
create index SE_PROMOVISE_FK on PROMOCIJE (
DRZAVA_U_KOJOJ_SE_NALAZI ASC,
ID_PRAVNOG_LICA ASC
)
go

/*==============================================================*/
/* Index: VRSTE_PROMOCIJE_FK                                    */
/*==============================================================*/
create index VRSTE_PROMOCIJE_FK on PROMOCIJE (
ID_TIPA_PROMOCIJE ASC
)
go

/*==============================================================*/
/* Table: RASPORED_RADNIH_MJESTA                                */
/*==============================================================*/
create table RASPORED_RADNIH_MJESTA (
   SIS_OZNAKA_DRZAVE    char(3)              not null,
   SIS_ID_PRAVNOG_LICA  int                  not null,
   RRM_REDNI_BROJ_RASPOREDA numeric(2)           not null,
   DRZAVA_U_KOJOJ_SE_P_LICE__NALAZI char(3)              not null,
   ID_PRAVNOG_LICA_GDJE_JE_ZAPOSLEN int                  not null,
   SRM_IDENTIFIKATOR    int                  not null,
   ID_ZAPOSLENOG        int                  not null,
   RRM_DATUM_OD         date                 not null,
   RRM_DATUM_DO         date                 null,
   constraint PK_RASPORED_RADNIH_MJESTA primary key nonclustered (SIS_OZNAKA_DRZAVE, SIS_ID_PRAVNOG_LICA, SRM_IDENTIFIKATOR, DRZAVA_U_KOJOJ_SE_P_LICE__NALAZI, ID_PRAVNOG_LICA_GDJE_JE_ZAPOSLEN, ID_ZAPOSLENOG, RRM_REDNI_BROJ_RASPOREDA)
)
go

/*==============================================================*/
/* Index: RADI_FK                                               */
/*==============================================================*/
create index RADI_FK on RASPORED_RADNIH_MJESTA (
DRZAVA_U_KOJOJ_SE_P_LICE__NALAZI ASC,
ID_PRAVNOG_LICA_GDJE_JE_ZAPOSLEN ASC,
ID_ZAPOSLENOG ASC
)
go

/*==============================================================*/
/* Index: R_MJESTO_FK                                           */
/*==============================================================*/
create index R_MJESTO_FK on RASPORED_RADNIH_MJESTA (
DRZAVA_U_KOJOJ_SE_P_LICE__NALAZI ASC,
ID_PRAVNOG_LICA_GDJE_JE_ZAPOSLEN ASC,
SRM_IDENTIFIKATOR ASC
)
go

/*==============================================================*/
/* Table: REGION                                                */
/*==============================================================*/
create table REGION (
   REG_OZNAKA           char(3)              not null,
   REG_NAZIV            varchar(60)          not null,
   TR_OZNAKA_TIPA       char(1)              not null,
   DRZAVA_U_KOJOJ_SE_NALAZI char(3)              null,
   NM_IDENTIFIKATOR     int                  null,
   constraint PK_REGION primary key nonclustered (TR_OZNAKA_TIPA, REG_OZNAKA)
)
go

/*==============================================================*/
/* Index: TIPIZACIJA_REGIONA_FK                                 */
/*==============================================================*/
create index TIPIZACIJA_REGIONA_FK on REGION (
TR_OZNAKA_TIPA ASC
)
go

/*==============================================================*/
/* Index: PRIPADA_DRZAVI_FK                                     */
/*==============================================================*/
create index PRIPADA_DRZAVI_FK on REGION (
DRZAVA_U_KOJOJ_SE_NALAZI ASC
)
go

/*==============================================================*/
/* Index: SEDISTE_REGIONA_FK                                    */
/*==============================================================*/
create index SEDISTE_REGIONA_FK on REGION (
NM_IDENTIFIKATOR ASC
)
go

/*==============================================================*/
/* Table: REGIONALNA_DRZAVA                                     */
/*==============================================================*/
create table REGIONALNA_DRZAVA (
   OZNAKA_DRZAVE        char(3)              not null,
   REG_OZNAKA           char(3)              not null,
   TR_OZNAKA_TIPA       char(1)              not null,
   DRR_OD               date                 not null,
   DRR_DO               date                 null,
   constraint PK_REGIONALNA_DRZAVA primary key nonclustered (TR_OZNAKA_TIPA, REG_OZNAKA, OZNAKA_DRZAVE, DRR_OD)
)
go

/*==============================================================*/
/* Index: REGIONI_DRZAVE_FK                                     */
/*==============================================================*/
create index REGIONI_DRZAVE_FK on REGIONALNA_DRZAVA (
OZNAKA_DRZAVE ASC
)
go

/*==============================================================*/
/* Index: REGION_U_DRZAVI_FK                                    */
/*==============================================================*/
create index REGION_U_DRZAVI_FK on REGIONALNA_DRZAVA (
TR_OZNAKA_TIPA ASC,
REG_OZNAKA ASC
)
go

/*==============================================================*/
/* Table: REGISTAR_DJELATNOSTI                                  */
/*==============================================================*/
create table REGISTAR_DJELATNOSTI (
   RD_IDENTIFIKATOR     char(2)              not null,
   RD_NAZIV             varchar(60)          not null,
   RD_SLUZBENAOZNAKA    varchar(30)          null,
   DRZAVA_U_KOJOJ_JE_REGISTROVAN char(3)              null,
   constraint PK_REGISTAR_DJELATNOSTI primary key nonclustered (RD_IDENTIFIKATOR)
)
go

/*==============================================================*/
/* Index: ZA_DRZAVU_FK                                          */
/*==============================================================*/
create index ZA_DRZAVU_FK on REGISTAR_DJELATNOSTI (
DRZAVA_U_KOJOJ_JE_REGISTROVAN ASC
)
go

/*==============================================================*/
/* Table: REGISTAR_ZAPOSLENIH                                   */
/*==============================================================*/
create table REGISTAR_ZAPOSLENIH (
   ID_ZAPOSLENOG        int                  not null,
   RZ_IME               varchar(40)          not null,
   RZ_PREZIME           varchar(40)          not null,
   RZ_IME_JEDNOG_RODITELJA varchar(40)          not null,
   RZ_POL               char(1)              not null default 'Z'
      constraint CKC_RZ_POL_REGISTAR check (RZ_POL in ('M','Z')),
   RZ_DATUM_RODJENJA    date                 not null,
   ID_PRAVNOG_LICA_GDJE_JE_ZAPOSLEN int                  not null,
   DRZAVA_U_KOJOJ_SE_P_LICE__NALAZI char(3)              not null,
   constraint PK_REGISTAR_ZAPOSLENIH primary key nonclustered (DRZAVA_U_KOJOJ_SE_P_LICE__NALAZI, ID_PRAVNOG_LICA_GDJE_JE_ZAPOSLEN, ID_ZAPOSLENOG)
)
go

/*==============================================================*/
/* Index: ZAPOSLENI_FK                                          */
/*==============================================================*/
create index ZAPOSLENI_FK on REGISTAR_ZAPOSLENIH (
DRZAVA_U_KOJOJ_SE_P_LICE__NALAZI ASC,
ID_PRAVNOG_LICA_GDJE_JE_ZAPOSLEN ASC
)
go

/*==============================================================*/
/* Table: SISTEMATIZACIJA_RADNIH_MJESTA                         */
/*==============================================================*/
create table SISTEMATIZACIJA_RADNIH_MJESTA (
   SRM_IDENTIFIKATOR    int                  not null,
   SRM_NAZIV            varchar(30)          not null,
   ID_PRAVNOG_LICA      int                  not null,
   DRZAVA_U_KOJOJ_SE_NALAZI char(3)              not null,
   constraint PK_SISTEMATIZACIJA_RADNIH_MJES primary key nonclustered (DRZAVA_U_KOJOJ_SE_NALAZI, ID_PRAVNOG_LICA, SRM_IDENTIFIKATOR)
)
go

/*==============================================================*/
/* Index: RADNA_MJESTA_FK                                       */
/*==============================================================*/
create index RADNA_MJESTA_FK on SISTEMATIZACIJA_RADNIH_MJESTA (
DRZAVA_U_KOJOJ_SE_NALAZI ASC,
ID_PRAVNOG_LICA ASC
)
go

/*==============================================================*/
/* Table: SLOZENA_DRZAVA                                        */
/*==============================================================*/
create table SLOZENA_DRZAVA (
   SD_REDNI_BROJ        numeric(2)           not null,
   OZNAKA_SLOZENE_DRZAVE char(3)              not null,
   OZNAKA_DRZAVE_CLANICE char(3)              not null,
   SD_OD                date                 null,
   SD_DO_KADA           date                 null,
   constraint PK_SLOZENA_DRZAVA primary key nonclustered (OZNAKA_DRZAVE_CLANICE, OZNAKA_SLOZENE_DRZAVE, SD_REDNI_BROJ)
)
go

/*==============================================================*/
/* Index: SLOZENA_FK                                            */
/*==============================================================*/
create index SLOZENA_FK on SLOZENA_DRZAVA (
OZNAKA_SLOZENE_DRZAVE ASC
)
go

/*==============================================================*/
/* Index: CLANICA_FK                                            */
/*==============================================================*/
create index CLANICA_FK on SLOZENA_DRZAVA (
OZNAKA_DRZAVE_CLANICE ASC
)
go

/*==============================================================*/
/* Table: STRUKTURA_NASELJA                                     */
/*==============================================================*/
create table STRUKTURA_NASELJA (
   DRZAVA_U_KOJOJ_SE_NALAZI char(3)              not null,
   NM_IDENTIFIKATOR     int                  not null,
   OP_OZNAKA            char(3)              not null,
   constraint PK_STRUKTURA_NASELJA primary key nonclustered (NM_IDENTIFIKATOR, DRZAVA_U_KOJOJ_SE_NALAZI, OP_OZNAKA)
)
go

/*==============================================================*/
/* Index: STRUKTURA_NASELJA2_FK                                 */
/*==============================================================*/
create index STRUKTURA_NASELJA2_FK on STRUKTURA_NASELJA (
DRZAVA_U_KOJOJ_SE_NALAZI ASC,
OP_OZNAKA ASC
)
go

/*==============================================================*/
/* Index: STRUKTURA_NASELJA_FK                                  */
/*==============================================================*/
create index STRUKTURA_NASELJA_FK on STRUKTURA_NASELJA (
NM_IDENTIFIKATOR ASC
)
go

/*==============================================================*/
/* Table: STRUKTURA_REGIONA                                     */
/*==============================================================*/
create table STRUKTURA_REGIONA (
   REG_OZNAKA           char(3)              not null,
   TR_OZNAKA_TIPA       char(1)              not null,
   REG_REG_OZNAKA       char(3)              not null,
   REG_TR_OZNAKA_TIPA   char(1)              not null,
   constraint PK_STRUKTURA_REGIONA primary key nonclustered (REG_TR_OZNAKA_TIPA, REG_REG_OZNAKA, TR_OZNAKA_TIPA, REG_OZNAKA)
)
go

/*==============================================================*/
/* Index: STRUKTURA_REGIONA2_FK                                 */
/*==============================================================*/
create index STRUKTURA_REGIONA2_FK on STRUKTURA_REGIONA (
TR_OZNAKA_TIPA ASC,
REG_OZNAKA ASC
)
go

/*==============================================================*/
/* Index: STRUKTURA_REGIONA_FK                                  */
/*==============================================================*/
create index STRUKTURA_REGIONA_FK on STRUKTURA_REGIONA (
REG_TR_OZNAKA_TIPA ASC,
REG_REG_OZNAKA ASC
)
go

/*==============================================================*/
/* Table: TIP_ARTIKLIA                                          */
/*==============================================================*/
create table TIP_ARTIKLIA (
   ID_TIPA_ARTIKLA      char(1)              not null,
   NAZIV                varchar(30)          not null,
   constraint PK_TIP_ARTIKLIA primary key nonclustered (ID_TIPA_ARTIKLA)
)
go

/*==============================================================*/
/* Table: TIP_CLANARINE                                         */
/*==============================================================*/
create table TIP_CLANARINE (
   ID_TIPA_CLANARINE    char(3)              not null,
   NAZIV_CLANARINE      varchar(20)          not null,
   OPIS                 varchar(50)          null,
   constraint PK_TIP_CLANARINE primary key nonclustered (ID_TIPA_CLANARINE)
)
go

/*==============================================================*/
/* Table: TIP_KORISNIKA_SISTEMA                                 */
/*==============================================================*/
create table TIP_KORISNIKA_SISTEMA (
   ID_TIPA_KORISNIKA_SISTEM char(3)              not null,
   NAZIV_KORISNIKA      varchar(20)          not null,
   OPIS                 varchar(50)          null,
   constraint PK_TIP_KORISNIKA_SISTEMA primary key nonclustered (ID_TIPA_KORISNIKA_SISTEM)
)
go

/*==============================================================*/
/* Table: TIP_PROIZVODNJE                                       */
/*==============================================================*/
create table TIP_PROIZVODNJE (
   ID_TIPA_PROIZVODNJE  char(1)              not null,
   NAZIV                varchar(30)          not null,
   OPIS                 varchar(50)          null,
   constraint PK_TIP_PROIZVODNJE primary key nonclustered (ID_TIPA_PROIZVODNJE)
)
go

/*==============================================================*/
/* Table: TIP_PROMOCIJE                                         */
/*==============================================================*/
create table TIP_PROMOCIJE (
   ID_TIPA_PROMOCIJE    char(1)              not null,
   NAZIV                varchar(30)          not null,
   OPIS                 varchar(50)          null,
   constraint PK_TIP_PROMOCIJE primary key nonclustered (ID_TIPA_PROMOCIJE)
)
go

/*==============================================================*/
/* Table: TIP_REGIONA                                           */
/*==============================================================*/
create table TIP_REGIONA (
   TR_OZNAKA_TIPA       char(1)              not null,
   TR_NAZIV             varchar(80)          not null,
   constraint PK_TIP_REGIONA primary key nonclustered (TR_OZNAKA_TIPA)
)
go

/*==============================================================*/
/* Table: TIP_SARADNJE                                          */
/*==============================================================*/
create table TIP_SARADNJE (
   ID_TIPA_SARADNJE     char(1)              not null,
   NAZIV                varchar(30)          not null,
   constraint PK_TIP_SARADNJE primary key nonclustered (ID_TIPA_SARADNJE)
)
go

/*==============================================================*/
/* Table: TIP_USLUGE                                            */
/*==============================================================*/
create table TIP_USLUGE (
   ID_TIPA_USLUGE       char(1)              not null,
   NAZIV                varchar(30)          not null,
   OPIS                 varchar(50)          null,
   constraint PK_TIP_USLUGE primary key nonclustered (ID_TIPA_USLUGE)
)
go

alter table AKT_O_ORGANIZACIJI
   add constraint FK_AKT_O_OR_AKT_O_ORG_ORGANIZA foreign key (DRZAVA_U_KOJOJ_SE_NALAZI, ID_PRAVNOG_LICA, OJ_IDENTIFIKACIJA)
      references ORGANIZACIONA_JEDINICA (DRZAVA_U_KOJOJ_SE_NALAZI, ID_PRAVNOG_LICA, OJ_IDENTIFIKACIJA)
go

alter table ARTIKLI_I_PRIMJERCI
   add constraint FK_ARTIKLI__POSJEDUJE_PRAVNO_L foreign key (DRZAVA_U_KOJOJ_SE_NALAZI, ID_PRAVNOG_LICA)
      references PRAVNO_LICE (DRZAVA_U_KOJOJ_SE_NALAZI, ID_PRAVNOG_LICA)
go

alter table ARTIKLI_I_PRIMJERCI
   add constraint FK_ARTIKLI__SU_PRIMJE_NASLOVI_ foreign key (ID_TIPA_ARTIKLA, ID_NASLOVA)
      references NASLOVI_I_OPIS (ID_TIPA_ARTIKLA, ID_NASLOVA)
go

alter table ARTIKLI_NA_RAZMJENI
   add constraint FK_ARTIKLI__KOJI_ARTI_ARTIKLI_ foreign key (DRZAVA_GDJE_JE_ARTIKAL, ID_P_LICA_ARTIKLA, ID_TIPA_ARTIKLA, ID_NASLOVA, ID_PRIMJERKA)
      references ARTIKLI_I_PRIMJERCI (DRZAVA_U_KOJOJ_SE_NALAZI, ID_PRAVNOG_LICA, ID_TIPA_ARTIKLA, ID_NASLOVA, ID_PRIMJERKA)
go

alter table ARTIKLI_NA_RAZMJENI
   add constraint FK_ARTIKLI__SA_KIM_SE_OSTVAREN foreign key (DRZAVA_MULTITEKA, ID_P_LICA_MULTITEKA, DRZAVA_POSLOVNI_PARTNER, ID_POSLOVNOG_PARTNERA, ID_SARADNJE)
      references OSTVARENE_SARADNJE (DRZAVA_MULTITEKA, ID_P_LICA_MULTITEKA, DRZAVA_POSLOVNI_PARTNER, ID_POSLOVNOG_PARTNERA, ID_SARADNJE)
go

alter table CJENOVNIK
   add constraint FK_CJENOVNI_KOJE_ARTI_NASLOVI_ foreign key (ID_TIPA_ARTIKLA, ID_NASLOVA)
      references NASLOVI_I_OPIS (ID_TIPA_ARTIKLA, ID_NASLOVA)
go

alter table CJENOVNIK
   add constraint FK_CJENOVNI_KOJE_PRAV_PRAVNO_L foreign key (DRZAVA_U_KOJOJ_SE_NALAZI, ID_PRAVNOG_LICA)
      references PRAVNO_LICE (DRZAVA_U_KOJOJ_SE_NALAZI, ID_PRAVNOG_LICA)
go

alter table CJENOVNIK
   add constraint FK_CJENOVNI_KOJE_USLU_TIP_USLU foreign key (ID_TIPA_USLUGE)
      references TIP_USLUGE (ID_TIPA_USLUGE)
go

alter table CJENOVNIK
   add constraint FK_CJENOVNI_KOJI_TIP__TIP_CLAN foreign key (ID_TIPA_CLANARINE)
      references TIP_CLANARINE (ID_TIPA_CLANARINE)
go

alter table CLANSKA_KARTA
   add constraint FK_CLANSKA__CIJI_CU_K_PRAVNO_L foreign key (DRZAVA_U_KOJOJ_SE_P_LICE_NALAZI, ID_PRAVNOG_LICA)
      references PRAVNO_LICE (DRZAVA_U_KOJOJ_SE_NALAZI, ID_PRAVNOG_LICA)
go

alter table CLANSKA_KARTA
   add constraint FK_CLANSKA__IMAJU_CLA_KLIJENTI foreign key (ID_KLIJENTA)
      references KLIJENTI (ID_KLIJENTA)
go

alter table CLANSKA_KARTA
   add constraint FK_CLANSKA__TIPICAZIJ_TIP_CLAN foreign key (ID_TIPA_CLANARINE)
      references TIP_CLANARINE (ID_TIPA_CLANARINE)
go

alter table DJELATNOST
   add constraint FK_DJELATNO_DJELATNOS_PRAVNO_L foreign key (DRZAVA_U_KOJOJ_SE_NALAZI, ID_PRAVNOG_LICA)
      references PRAVNO_LICE (DRZAVA_U_KOJOJ_SE_NALAZI, ID_PRAVNOG_LICA)
go

alter table DJELATNOST
   add constraint FK_DJELATNO_DJELATNOS_REGISTAR foreign key (RD_IDENTIFIKATOR)
      references REGISTAR_DJELATNOSTI (RD_IDENTIFIKATOR)
go

alter table DRZAVA
   add constraint FK_DRZAVA_GLAVNI_GR_NASELJEN foreign key (NM_IDENTIFIKATOR)
      references NASELJENO_MJESTO (NM_IDENTIFIKATOR)
go

alter table DRZAVA
   add constraint FK_DRZAVA_PRAVNI_NA_DRZAVA foreign key (DRZAVA_PRAVNI_NASLJEDNIK)
      references DRZAVA (OZNAKA_DRZAVE)
go

alter table MJESTA_U_DRZAVI
   add constraint FK_MJESTA_U_NALAZI_SE_NASELJEN foreign key (NM_IDENTIFIKATOR)
      references NASELJENO_MJESTO (NM_IDENTIFIKATOR)
go

alter table MJESTA_U_DRZAVI
   add constraint FK_MJESTA_U_SADRZI_MJ_DRZAVA foreign key (OZNAKA_DRZAVE)
      references DRZAVA (OZNAKA_DRZAVE)
go

alter table NASLOVI_I_OPIS
   add constraint FK_NASLOVI__TIPIZACIJ_TIP_ARTI foreign key (ID_TIPA_ARTIKLA)
      references TIP_ARTIKLIA (ID_TIPA_ARTIKLA)
go

alter table OBAVLJENE_USLUGE
   add constraint FK_OBAVLJEN_KO_ZAHTJE_CLANSKA_ foreign key (DRZAVA_U_KOJOJ_SE_P_LICE_NALAZI, ID_PRAVNOG_LICA, ID_KLIJENTA, ID_CLANSKE_KARTE)
      references CLANSKA_KARTA (DRZAVA_U_KOJOJ_SE_P_LICE_NALAZI, ID_PRAVNOG_LICA, ID_KLIJENTA, ID_CLANSKE_KARTE)
go

alter table OBAVLJENE_USLUGE
   add constraint FK_OBAVLJEN_SA_KOJIM__ARTIKLI_ foreign key (DRZAVA_U_KOJOJ_SE_P_LICE_NALAZI, ID_PRAVNOG_LICA, ID_TIPA_ARTIKLA, ID_NASLOVA, ID_PRIMJERKA)
      references ARTIKLI_I_PRIMJERCI (DRZAVA_U_KOJOJ_SE_NALAZI, ID_PRAVNOG_LICA, ID_TIPA_ARTIKLA, ID_NASLOVA, ID_PRIMJERKA)
go

alter table OBAVLJENE_USLUGE
   add constraint FK_OBAVLJEN_TIPIZACIJ_TIP_USLU foreign key (ID_TIPA_USLUGE)
      references TIP_USLUGE (ID_TIPA_USLUGE)
go

alter table OPSTINE
   add constraint FK_OPSTINE_LOKALNA_S_DRZAVA foreign key (DRZAVA_U_KOJOJ_SE_NALAZI)
      references DRZAVA (OZNAKA_DRZAVE)
go

alter table OPSTINE
   add constraint FK_OPSTINE_SEDISTE_O_NASELJEN foreign key (NM_IDENTIFIKATOR)
      references NASELJENO_MJESTO (NM_IDENTIFIKATOR)
go

alter table ORGANIZACIJA
   add constraint FK_ORGANIZA_ORGANIZAC_AKT_O_OR foreign key (DRZAVA_U_KOJOJ_SE_NALAZI, ID_PRAVNOG_LICA, AKT_OJ_IDENTIFIKACIJA, AO_BROJ_AKTA)
      references AKT_O_ORGANIZACIJI (DRZAVA_U_KOJOJ_SE_NALAZI, ID_PRAVNOG_LICA, OJ_IDENTIFIKACIJA, AO_BROJ_AKTA)
go

alter table ORGANIZACIJA
   add constraint FK_ORGANIZA_ORGANIZAC_ORGANIZA foreign key (DRZAVA_U_KOJOJ_SE_NALAZI, ID_PRAVNOG_LICA, AKT_OJ_IDENTIFIKACIJA)
      references ORGANIZACIONA_JEDINICA (DRZAVA_U_KOJOJ_SE_NALAZI, ID_PRAVNOG_LICA, OJ_IDENTIFIKACIJA)
go

alter table ORGANIZACIONA_JEDINICA
   add constraint FK_ORGANIZA_ORGANIZAC_PRAVNO_L foreign key (DRZAVA_U_KOJOJ_SE_NALAZI, ID_PRAVNOG_LICA)
      references PRAVNO_LICE (DRZAVA_U_KOJOJ_SE_NALAZI, ID_PRAVNOG_LICA)
go

alter table ORGANIZACIONA_JEDINICA
   add constraint FK_ORGANIZA_SEDISTE_J_NASELJEN foreign key (NM_IDENTIFIKATOR)
      references NASELJENO_MJESTO (NM_IDENTIFIKATOR)
go

alter table OSTVARENE_SARADNJE
   add constraint FK_OSTVAREN_KOJA_MULT_PRAVNO_L foreign key (DRZAVA_MULTITEKA, ID_P_LICA_MULTITEKA)
      references PRAVNO_LICE (DRZAVA_U_KOJOJ_SE_NALAZI, ID_PRAVNOG_LICA)
go

alter table OSTVARENE_SARADNJE
   add constraint FK_OSTVAREN_KOJI_PART_PRAVNO_L foreign key (DRZAVA_POSLOVNI_PARTNER, ID_POSLOVNOG_PARTNERA)
      references PRAVNO_LICE (DRZAVA_U_KOJOJ_SE_NALAZI, ID_PRAVNOG_LICA)
go

alter table OSTVARENE_SARADNJE
   add constraint FK_OSTVAREN_TIPIZACIJ_TIP_SARA foreign key (ID_TIPA_SARADNJE)
      references TIP_SARADNJE (ID_TIPA_SARADNJE)
go

alter table PODACI_ZA_LOGOVANJE
   add constraint FK_PODACI_Z_KORISNICI_KLIJENTI foreign key (ID_KLIJENTA)
      references KLIJENTI (ID_KLIJENTA)
go

alter table PODACI_ZA_LOGOVANJE
   add constraint FK_PODACI_Z_KORISNICI_REGISTAR foreign key (DRZAVA_U_KOJOJ_SE_P_LICE__NALAZI, ID_PRAVNOG_LICA_GDJE_JE_ZAPOSLEN, ID_ZAPOSLENOG)
      references REGISTAR_ZAPOSLENIH (DRZAVA_U_KOJOJ_SE_P_LICE__NALAZI, ID_PRAVNOG_LICA_GDJE_JE_ZAPOSLEN, ID_ZAPOSLENOG)
go

alter table PODACI_ZA_LOGOVANJE
   add constraint FK_PODACI_Z_TIPIZACIJ_TIP_KORI foreign key (ID_TIPA_KORISNIKA_SISTEM)
      references TIP_KORISNIKA_SISTEMA (ID_TIPA_KORISNIKA_SISTEM)
go

alter table POTREBA_ZA
   add constraint FK_POTREBA__KOJIH_ART_NASLOVI_ foreign key (ID_TIPA_ARTIKLA, ID_NASLOVA)
      references NASLOVI_I_OPIS (ID_TIPA_ARTIKLA, ID_NASLOVA)
go

alter table POTREBA_ZA
   add constraint FK_POTREBA__POTREBA_Z_PRAVNO_L foreign key (DRZAVA_U_KOJOJ_SE_NALAZI, ID_PRAVNOG_LICA)
      references PRAVNO_LICE (DRZAVA_U_KOJOJ_SE_NALAZI, ID_PRAVNOG_LICA)
go

alter table POTREBA_ZA
   add constraint FK_POTREBA__TIPIZACIJ_TIP_PROI foreign key (ID_TIPA_PROIZVODNJE)
      references TIP_PROIZVODNJE (ID_TIPA_PROIZVODNJE)
go

alter table PRAVNO_LICE
   add constraint FK_PRAVNO_L_PRAVNI_NA_PRAVNO_L foreign key (PRAVNI_NASLJEDNIK_DRZAVA, PRAVNI_NASLJENIK_PRAVNO_LICE)
      references PRAVNO_LICE (DRZAVA_U_KOJOJ_SE_NALAZI, ID_PRAVNOG_LICA)
go

alter table PRAVNO_LICE
   add constraint FK_PRAVNO_L_REGISTROV_DRZAVA foreign key (DRZAVA_U_KOJOJ_SE_NALAZI)
      references DRZAVA (OZNAKA_DRZAVE)
go

alter table PRAVNO_LICE
   add constraint FK_PRAVNO_L_SEDISTE_P_NASELJEN foreign key (NM_IDENTIFIKATOR)
      references NASELJENO_MJESTO (NM_IDENTIFIKATOR)
go

alter table PROMOCIJE
   add constraint FK_PROMOCIJ_SE_PROMOV_PRAVNO_L foreign key (DRZAVA_U_KOJOJ_SE_NALAZI, ID_PRAVNOG_LICA)
      references PRAVNO_LICE (DRZAVA_U_KOJOJ_SE_NALAZI, ID_PRAVNOG_LICA)
go

alter table PROMOCIJE
   add constraint FK_PROMOCIJ_VRSTE_PRO_TIP_PROM foreign key (ID_TIPA_PROMOCIJE)
      references TIP_PROMOCIJE (ID_TIPA_PROMOCIJE)
go

alter table RASPORED_RADNIH_MJESTA
   add constraint FK_RASPORED_RADI_REGISTAR foreign key (DRZAVA_U_KOJOJ_SE_P_LICE__NALAZI, ID_PRAVNOG_LICA_GDJE_JE_ZAPOSLEN, ID_ZAPOSLENOG)
      references REGISTAR_ZAPOSLENIH (DRZAVA_U_KOJOJ_SE_P_LICE__NALAZI, ID_PRAVNOG_LICA_GDJE_JE_ZAPOSLEN, ID_ZAPOSLENOG)
go

alter table RASPORED_RADNIH_MJESTA
   add constraint FK_RASPORED_R_MJESTO_SISTEMAT foreign key (DRZAVA_U_KOJOJ_SE_P_LICE__NALAZI, ID_PRAVNOG_LICA_GDJE_JE_ZAPOSLEN, SRM_IDENTIFIKATOR)
      references SISTEMATIZACIJA_RADNIH_MJESTA (DRZAVA_U_KOJOJ_SE_NALAZI, ID_PRAVNOG_LICA, SRM_IDENTIFIKATOR)
go

alter table REGION
   add constraint FK_REGION_PRIPADA_D_DRZAVA foreign key (DRZAVA_U_KOJOJ_SE_NALAZI)
      references DRZAVA (OZNAKA_DRZAVE)
go

alter table REGION
   add constraint FK_REGION_SEDISTE_R_NASELJEN foreign key (NM_IDENTIFIKATOR)
      references NASELJENO_MJESTO (NM_IDENTIFIKATOR)
go

alter table REGION
   add constraint FK_REGION_TIPIZACIJ_TIP_REGI foreign key (TR_OZNAKA_TIPA)
      references TIP_REGIONA (TR_OZNAKA_TIPA)
go

alter table REGIONALNA_DRZAVA
   add constraint FK_REGIONAL_REGIONI_D_DRZAVA foreign key (OZNAKA_DRZAVE)
      references DRZAVA (OZNAKA_DRZAVE)
go

alter table REGIONALNA_DRZAVA
   add constraint FK_REGIONAL_REGION_U__REGION foreign key (TR_OZNAKA_TIPA, REG_OZNAKA)
      references REGION (TR_OZNAKA_TIPA, REG_OZNAKA)
go

alter table REGISTAR_DJELATNOSTI
   add constraint FK_REGISTAR_ZA_DRZAVU_DRZAVA foreign key (DRZAVA_U_KOJOJ_JE_REGISTROVAN)
      references DRZAVA (OZNAKA_DRZAVE)
go

alter table REGISTAR_ZAPOSLENIH
   add constraint FK_REGISTAR_ZAPOSLENI_PRAVNO_L foreign key (DRZAVA_U_KOJOJ_SE_P_LICE__NALAZI, ID_PRAVNOG_LICA_GDJE_JE_ZAPOSLEN)
      references PRAVNO_LICE (DRZAVA_U_KOJOJ_SE_NALAZI, ID_PRAVNOG_LICA)
go

alter table SISTEMATIZACIJA_RADNIH_MJESTA
   add constraint FK_SISTEMAT_RADNA_MJE_PRAVNO_L foreign key (DRZAVA_U_KOJOJ_SE_NALAZI, ID_PRAVNOG_LICA)
      references PRAVNO_LICE (DRZAVA_U_KOJOJ_SE_NALAZI, ID_PRAVNOG_LICA)
go

alter table SLOZENA_DRZAVA
   add constraint FK_SLOZENA__CLANICA_DRZAVA foreign key (OZNAKA_DRZAVE_CLANICE)
      references DRZAVA (OZNAKA_DRZAVE)
go

alter table SLOZENA_DRZAVA
   add constraint FK_SLOZENA__SLOZENA_DRZAVA foreign key (OZNAKA_SLOZENE_DRZAVE)
      references DRZAVA (OZNAKA_DRZAVE)
go

alter table STRUKTURA_NASELJA
   add constraint FK_STRUKTUR_STRUKTURA_NASELJEN foreign key (NM_IDENTIFIKATOR)
      references NASELJENO_MJESTO (NM_IDENTIFIKATOR)
go

alter table STRUKTURA_NASELJA
   add constraint FK_STRUKTUR_STRUKTURA_OPSTINE foreign key (DRZAVA_U_KOJOJ_SE_NALAZI, OP_OZNAKA)
      references OPSTINE (DRZAVA_U_KOJOJ_SE_NALAZI, OP_OZNAKA)
go

alter table STRUKTURA_REGIONA
   add constraint FK_STRUKTUR_STRUKTURA_REGION foreign key (REG_TR_OZNAKA_TIPA, REG_REG_OZNAKA)
      references REGION (TR_OZNAKA_TIPA, REG_OZNAKA)
go

alter table STRUKTURA_REGIONA
   add constraint FK_STRUKTUR_STRUKTURA_REGION2 foreign key (TR_OZNAKA_TIPA, REG_OZNAKA)
      references REGION (TR_OZNAKA_TIPA, REG_OZNAKA)
go

