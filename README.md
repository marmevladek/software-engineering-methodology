# Software Engineering Methodology

---

## MAGE / МАГ
### Создать пользователя
API:
```
POST http://localhost:8080/api/mage/user/create
```
JSON:
```
{
    "email": "vl@gmail.com",
    "password": "123123",
    "surname": "qwerty",
    "firstName": "asdfghh",
    "patronymic": "zxcvvb",
    "role": 2
}
```
### Отправить заявку на получение магии
API:
```
POST http://localhost:8080/api/hunter/order/create
```
JSON:
```
{   
    "magicId": 2,
    "title": "full title",
    "deadline": "10-08-2011",
    "quantity": 12
}
```

### Получить список всех отправленных (от мага) заявок
API:
```
GET http://localhost:8080/api/mage/my-orders
```

---
## STORER / КЛАДОВЩИК

### Создать заявку на магическое существо
API:
```
POST http://localhost:8080/api/storer/order/create
```
JSON:
```
{   
    "name": "vlados",
    "title": "full title",
    "deadline": "10-08-2011",
    "quantity": 12
}
```

### Получить список всех отправленных (от кладовщика) заявок
API:
```
GET http://localhost:8080/api/storer/my-orders
```

### Получить список заявок на магию
API
```
GET http://localhost:8080/api/storer/orders
```

### Получить подробную информацию о конкретной заявке (возможно эта ручка не нужна будет в дальнейшем)
API:
- id - UUID - идентификатор заявки
```
GET http://localhost:8080/api/storer/orders/{id}
```

### Проверить наличие магии (возможно эта ручка уйдет во внутреннюю логику бэка для большей автоматизации)
API:
- id - LONG - индекс магии, которую нужно проверить
- requestedVolume - int - требуемый объем магии
```
GET http://localhost:8080/api/storer/magics/{id}/availability?requestedVolume={requestedVolume}
```

### Закрыть заявку на магию (переводит статус заявки из IN_PROGRESS в DONE)
API:
- id - UUID - идентификатор заявки
```
PUT http://localhost:8080/api/storer/orders/{id}
```
---

## HUNTER / ОХОТНИК

### Создать заявку на высасывание магии
API:
```
POST http://localhost:8080/api/hunter/order/create
```
JSON:
```
{   
    "magicId": 2,
    "title": "full title",
    "deadline": "10-08-2011",
    "quantity": 12
}
```

### Получить список всех отправленных (от охотника) заявок
API:
```
GET http://localhost:8080/api/hunter/my-orders
```

### Получить список заявок на магическое существо
API
```
GET http://localhost:8080/api/hunter/orders
```

### Получить подробную информацию о конкретной заявке (возможно эта ручка не нужна будет в дальнейшем)
API:
- id - UUID - идентификатор заявки
```
GET http://localhost:8080/api/hunter/orders/{id}
```

### Проверить наличие магического существа (возможно эта ручка уйдет во внутреннюю логику бэка для большей автоматизации)
Ручка пока что работает не по name, а по id (Long). Пофикшу, если эта ручка останется на внешке бэка.

API:
- name - String - наименование магического существа
- requestedQuantity - int - требуемое количество магических существ
```
GET http://localhost:8080/api/hunter/creatures/{name}/availability?requestedQuantity={requestedQuantity}
```

### Закрыть заявку на магическое существо (переводит статус заявки из IN_PROGRESS в DONE)
API:
- id - UUID - идентификатор заявки
```
PUT http://localhost:8080/api/hunter/orders/{id}
```

### Обновить информацию о магическом существе 

IN PROGRESS

---

## EXHAUSTION / ВЫСАСЫВАТЕЛЬ

### Получить список заявок на высасывание
API
```
GET http://localhost:8080/api/exhaustion/orders
```

### Получить подробную информацию о конкретной заявке (возможно эта ручка не нужна будет в дальнейшем)
API:
- id - UUID - идентификатор заявки
```
GET http://localhost:8080/api/exhaustion/orders/{id}
```
### Обновить информацию о магии
Внутри этой ручки также реализован функционал изменения статуса из IN_PROGRESS в DONE.

API:
- orderId - UUID - идентификатор заявки по которой магия пополняется
```
PUT http://localhost:8080/api/exhaustion/magic/add?orderId={orderId}
```
JSON:
- id - индекс магии, которую нужно пополнить
- volume - объем пополняемой магии
```
{
    "id": 1,
    "volume": 100
}
```