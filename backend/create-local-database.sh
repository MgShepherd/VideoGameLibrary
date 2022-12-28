#!/bin/zsh

readonly MYSQL=$(which mysql)
readonly DROP_DB_IF_EXISTS="DROP DATABASE IF EXISTS VideoGames;"
readonly CREATE_DB_STATEMENT="CREATE DATABASE IF NOT EXISTS VideoGames;USE VideoGames;"
readonly CREATE_GAME_TABLE="CREATE TABLE IF NOT EXISTS Games (
name varchar(255) NOT NULL,
publisher varchar(255),
release_date DATE,
genre varchar(255),
image_url varchar(255),
PRIMARY KEY (name, publisher));"

$MYSQL -uroot -p -e "$DROP_DB_IF_EXISTS$CREATE_DB_STATEMENT$CREATE_GAME_TABLE"