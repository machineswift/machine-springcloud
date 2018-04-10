--drop table TB_DEPT

-- Create table
create table TB_DEPT
(
  id               number(18),
  code             varchar2(64),
  name             varchar2(64),
  location       varchar2(64)
)tablespace SPRINGCLOUD8001_DATA ;
-- Add comments to the table 
comment on table TB_DEPT is '部门表';
-- Add comments to the columns 
comment on column TB_DEPT.id is 'ID';
comment on column TB_DEPT.code is '编码';
comment on column TB_DEPT.name is '名称';  
comment on column TB_DEPT.location is '地址';

-- Create/Recreate primary
alter table TB_DEPT add constraint PK_DEPT primary key (id)  using index  tablespace SPRINGCLOUD8001_DATA;  
  
-- Create/Recreate foreign

-- Create/Recreate default 

-- Create/Recreate  constraint 

-- Create/Recreate unique 
ALTER TABLE TB_DEPT ADD CONSTRAINT UK01_DEPT UNIQUE (code) using index tablespace SPRINGCLOUD8001_DATA;
  
--新增序列
create sequence SEQ_DEPT minvalue 1 maxvalue 999999999999999999 start with 1 increment by 1 cache 20; 

--初始化数据
insert into  TB_DEPT (id,code,name,location) values (SEQ_DEPT.nextval,'DEPT0001','开发部',user);
insert into  TB_DEPT (id,code,name,location) values (SEQ_DEPT.nextval,'DEPT0002','财务部',user);
insert into  TB_DEPT (id,code,name,location) values (SEQ_DEPT.nextval,'DEPT0003','市场部',user);
insert into  TB_DEPT (id,code,name,location) values (SEQ_DEPT.nextval,'DEPT0004','后勤部',user);
insert into  TB_DEPT (id,code,name,location) values (SEQ_DEPT.nextval,'DEPT0005','公关部',user);