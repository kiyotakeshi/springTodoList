# Setup DB and test data

- get docker image

```shell
$ docker pull mysql
$ docker pull busybox
```

- start container

```shell
$ docker run -v /var/lib/mysql --name mysql_data busybox
$ docker run --volumes-from mysql_data --name mysql -e MYSQL_ROOT_PASSWORD=mysql -d -p 3306:3306 mysql
```

- enter into MySQL container

```shell
$ docker container ls
$ docker exec -e LANG=C.UTF-8 -it $(docker container ls --filter "name=mysql" -q) bash
```

- connect into DB

```shell
$ mysql -u root -pmysql
```

- create test data(database,table,record)
  - use before CRUD implement

```sql
CREATE DATABASE TodoListDB;

USE TodoListDB;

CREATE TABLE todo_list_info (
  item_id INT AUTO_INCREMENT NOT NULL PRIMARY KEY COMMENT'アイテムID シーケンスによる自動採番'
  , register_date VARCHAR(20) NOT NULL COMMENT'日時'
  , todo_item VARCHAR(20) NOT NULL COMMENT'やること'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- not required process
-- optional process(if you want to insert test data)
INSERT INTO todo_list_info
 (register_date, todo_item)
 values('2019/10/05','Buy ketchup');

INSERT INTO todo_list_info
 (register_date, todo_item)
 values('2019/10/06','Go to bank');

INSERT INTO todo_list_info
 (register_date, todo_item)
 values('2019/10/07','Sleep a lot');
```

- delete test data(database,table,record)

```sql
delete from todo_list_info where item_id in(1,2,3);

-- if you want to reset table or db
DROP TABLE todo_list_info;

DROP DATABASE TodoListDB;
```
