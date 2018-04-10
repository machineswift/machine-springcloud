/*创建表空间*/

/*删除用户以及用户所有的对象*/
drop user SPRINGCLOUD8001 cascade;
/*删除表空间与表空间文件（注意：如果在创建表空间的时候带有双引号，则删除的时候也要带上）*/
DROP TABLESPACE SPRINGCLOUD8001_DATA INCLUDING CONTENTS AND DATAFILES;

 /*分为四步 */
/*第1步：创建临时表空间  (可以不执行)*/
create temporary tablespace  TEMP
tempfile 'C:\app\machine\oradata\orcl\TEMP.dbf'
size 50m  autoextend on next 50m maxsize 2048m  extent management local; 
 
/*第2步：创建数据表空间  */
create tablespace SPRINGCLOUD8001_DATA 
datafile 'C:\app\machine\oradata\orcl\SPRINGCLOUD8001_DATA.dbf'
size 50m  autoextend on next 50m maxsize 8192m extent management local;

/*第3步：创建用户并指定表空间  */
create user SPRINGCLOUD8001 identified by SPRINGCLOUD8001 default tablespace SPRINGCLOUD8001_DATA temporary tablespace TEMP;

/*第4步：给用户授予权限  */
grant connect,resource,dba,exp_full_database,imp_full_database to SPRINGCLOUD8001;