#!/bin/zsh

readonly MYSQL=$(which mysql)
readonly CREATE_DB_STATEMENT="CREATE DATABASE IF NOT EXISTS VideoGames;USE VideoGames;"
readonly CREATE_GAME_TABLE="CREATE TABLE IF NOT EXISTS Games (
id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
name varchar(255) NOT NULL,
publisher varchar(255),
release_date DATE,
genre varchar(255));"

$MYSQL -uroot -p -e "$CREATE_DB_STATEMENT$CREATE_GAME_TABLE"