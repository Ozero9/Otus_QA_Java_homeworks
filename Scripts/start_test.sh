#!/bin/bash

# Разбор параметров
url=""
browser_name=""
browser_version=""

while [[ "$#" -gt 0 ]]; do
    case $1 in
        --url) url="$2"; shift ;;
        --browser) browser_name="$2"; shift ;;
        --version) browser_version="$2"; shift ;;
        *) echo "Неизвестный параметр: $1" ;;
    esac
    shift
done

# Если параметры не заданы, запрашиваем у пользователя
if [[ -z "$url" || -z "$browser_name" || -z "$browser_version" ]]; then
    if [[ -z "$url" ]]; then
        read -p "Введите URL: " url
    fi
    if [[ -z "$browser_name" ]]; then
        read -p "Введите имя браузера: " browser_name
    fi
    if [[ -z "$browser_version" ]]; then
        read -p "Введите версию браузера: " browser_version
    fi
fi

# Проверка параметров
if [[ -z "$url" || -z "$browser_name" || -z "$browser_version" ]]; then
    echo "Не все параметры заданы"
    exit 1
fi

# Запуск тестов на Selenium Grid
mvn test -Dselenium.url="$url" -Dbrowser.name="$browser_name" -Dbrowser.version="$browser_version"
