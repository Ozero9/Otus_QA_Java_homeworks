#!/bin/bash
SCRIPT_DIR="./Scripts/"

# Меню выбора
echo "Выберите скрипт для выполнения:"
echo "1) calculator.sh"
echo "2) change_ext.sh"
echo "3) search_info.sh"
echo "4) start_test.sh"
read -p "Введите номер скрипта (1-4): " choice

# Выполнение выбранного скрипта
case $choice in
    1)
        bash "${SCRIPT_DIR}calculator.sh"
        ;;
    2)
        bash "${SCRIPT_DIR}change_ext.sh"
        ;;
    3)
        bash "${SCRIPT_DIR}search_info.sh"
        ;;
    4)
        bash "${SCRIPT_DIR}start_test.sh"
        ;;
    *)
        echo "Неверный выбор. Пожалуйста, выберите номер от 1 до 4."
        ;;
esac
