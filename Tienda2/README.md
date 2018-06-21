> ## APLICACIÓN DE TIENDA (DAM-UPAO2018)
> ### Integrantes del grupo:
> - Fernando Calmet Ramírez
> - Miguel Norabuena Díaz

> ## PROTOTIPOS
>  ![actividad inicial](http://prntscr.com/jwsua3) ![actividad menu principal](http://prntscr.com/jwsywi)
>  ![actividad catalogo](http://prntscr.com/jwt33z) ![actividad producto](http://prntscr.com/jwt3dr)
>  ![actividad login](http://prntscr.com/jwt2iw) ![actividad cliente](http://prntscr.com/jwt2va)
>  ![actividad recargas](http://prntscr.com/jwt200) ![actividad ayuda](http://prntscr.com/jwt0l1)
>  ![actividad promociones](http://prntscr.com/jwt28x)
>  ![actividad admincp](http://prntscr.com/jwt5jp) ![actividad admincp lista productos](http://prntscr.com/jwt5p3)
  
> ## HISTORIA DE USUARIO
>
>>| | |
>>|--|--|
>>| **NOMBRE** | ACTIVIDAD INICIAL |
>>| USUARIO | Cliente |
>>| PRIORIDAD | Baja |
>>| RIESGO | Bajo |
>>| PUNTOS ESTIMADOS | 1 |
>>| PROGRAMADOR | Miguel Norabuena |
>>| DESCRIPCIÓN | Mostrar pequeña animación con el logotipo de la tienda |
>>| VALIDACIÓN | Abrir la aplicación |
> ##
>>| | |
>>|--|--|
>>| **NOMBRE** | MENÚ PRINCIPAL |
>>| USUARIO | Cliente |
>>| PRIORIDAD | Alta |
>>| RIESGO | Bajo |
>>| PUNTOS ESTIMADOS | 3 |
>>| PROGRAMADOR | Miguel Norabuena |
>>| DESCRIPCIÓN | Mostrar menú principal de la aplicación, mostrando solo las actividades donde se podrá navegar únicamente como un usuario visitante (vista pública, sin sesión). |
>>| VALIDACIÓN | El usuario selecciona una opción del menú. |
> ##
>>| | |
>>|--|--|
>>| **NOMBRE** | CATALOGO DE PRODUCTOS |
>>| USUARIO | Cliente |
>>| PRIORIDAD | Alta |
>>| RIESGO | Bajo |
>>| PUNTOS ESTIMADOS | 10 |
>>| PROGRAMADOR | Fernando Calmet |
>>| DESCRIPCIÓN | El usuario puede ver: lista de todos los productos de la tienda, lista de productos en el carrito,y lista de productos favoritos. |
>>| VALIDACIÓN | El usuario debe seleccionar un producto para ver detalles |
> ##
>>| | |
>>|--|--|
>>| **NOMBRE** | DETALLES DEL PRODUCTO |
>>| USUARIO | Cliente |
>>| PRIORIDAD | Alta |
>>| RIESGO | Bajo |
>>| PUNTOS ESTIMADOS | 5 |
>>| PROGRAMADOR | Fernando Calmet |
>>| DESCRIPCIÓN | El usuario puede ver los detalles del producto seleccionado del catalogo. |
>>| VALIDACIÓN | El usuario debe seleccionar un producto de la lista. |
> ##
>>| | |
>>|--|--|
>>| **NOMBRE** | LOGIN |
>>| USUARIO | Cliente |
>>| PRIORIDAD | Alta |
>>| RIESGO | Alta |
>>| PUNTOS ESTIMADOS | 8 |
>>| PROGRAMADOR | Fernando Calmet |
>>| DESCRIPCIÓN | Conectarse a la sección de usuarios del sistema de la tienda, como Cliente o Administrador. |
>>| VALIDACIÓN | Si el usuario existe en el registro del sistema permitir al usuario conectarse al sistema de la tienda. |
> ##
>>| | |
>>|--|--|
>>| **NOMBRE** | ÁREA DE CLIENTES |
>>| USUARIO | Cliente |
>>| PRIORIDAD | Alta |
>>| RIESGO | Alto |
>>| PUNTOS ESTIMADOS | 10 |
>>| PROGRAMADOR | Fernando Calmet |
>>| DESCRIPCIÓN | El usuario autenticado puede añadir productos a su carrito de compras. |
>>| VALIDACIÓN | El usuario debe haber iniciado sesión correctamente. |
> ##
>>| | |
>>|--|--|
>>| **NOMBRE** | RECARGAS Y TARIFAS |
>>| USUARIO | Cliente |
>>| PRIORIDAD | Baja |
>>| RIESGO | Bajo |
>>| PUNTOS ESTIMADOS | 4 |
>>| PROGRAMADOR | Miguel Norabuena |
>>| DESCRIPCIÓN | El usuario puede ver información sobre como recargar saldo a su cuenta de la tienda. |
>>| VALIDACIÓN | Deslizar hacia la derecha o izquierda para navegar diferentes pantallas. |
> ##
>>| | |
>>|--|--|
>>| **NOMBRE** | AYUDA Y PREGUNTAS FRECUENTES |
>>| USUARIO | Cliente |
>>| PRIORIDAD | Baja |
>>| RIESGO | Bajo |
>>| PUNTOS ESTIMADOS | 4 |
>>| PROGRAMADOR | Miguel Norabuena |
>>| DESCRIPCIÓN | El usuario puede ver información sobre preguntas frecuentes del comprador. |
>>| VALIDACIÓN | Deslizar hacia la derecha o izquierda para navegar diferentes pantallas. |
> ##
>>| | |
>>|--|--|
>>| **NOMBRE** | PROMOCIONES |
>>| USUARIO | Cliente |
>>| PRIORIDAD | Baja |
>>| RIESGO | Bajo |
>>| PUNTOS ESTIMADOS | 8 |
>>| PROGRAMADOR | Fernando Calmet |
>>| DESCRIPCIÓN | El usuario puede ver información sobre las novedades, promociones y lista de productos de la tienda. |
>>| VALIDACIÓN | El usuario debe deslizar hacia abajo o arriba para ver mas promociones. |
> ##
>>| | |
>>|--|--|
>>| **NOMBRE** | PANEL DE ADMINISTRADOR |
>>| USUARIO | Administrador |
>>| PRIORIDAD | Alto |
>>| RIESGO | Alto |
>>| PUNTOS ESTIMADOS | 10 |
>>| PROGRAMADOR | Fernando Calmet |
>>| DESCRIPCIÓN | El usuario puede añadir productos al catalogo de la tienda. |
>>| VALIDACIÓN | Para ingresar productos debe validar si el usuario es de rol administrador. |
> ##
>>| | |
>>|--|--|
>>| **NOMBRE** | LISTA DE PRODUCTOS DEL ADMINISTRADOR |
>>| USUARIO | Administrador |
>>| PRIORIDAD | Bajo |
>>| RIESGO | Bajo |
>>| PUNTOS ESTIMADOS | 5 |
>>| PROGRAMADOR | Fernando Calmet |
>>| DESCRIPCIÓN | El usuario puede ver los productos ingresados a la tienda. |
>>| VALIDACIÓN | Deben haber productos ingresados para mostrar la lista. |

>## BASE DATOS ESTRUCTURADA
>  ![Diagrama](http://prntscr.com/jwurkw)

>## BASE DATOS FIREBASE
>![Firebase DB](http://prntscr.com/jxr1w1)
>  ![Promociones](http://prntscr.com/jwtbh0)
>  ![Productos](http://prntscr.com/jxqxg5)

>## LISTA DE PROBLEMAS
>  - En la actividad de Administrador de productos se debe corregir la foto que cargó al ingresar el producto, no se muestra en la lista al consultar.
>  - En la actividad de tienda se debe borrar los productos insertados por objeto en el código. Para leer la lista de la tabla del SQLite.
>  - En la actividad de tienda la función del carrito y favoritos aun no esta implementado.
>  - En la actividad de tienda al presionar sobre un producto de la lista, las opciones de añadir y ver detalles aún no están implementadas.

>## SCREENSHOTS DE LA APLICACIÓN
> ![actividad inicial](http://prntscr.com/jxr72o) ![actividad menu principal](http://prntscr.com/jxr789)
> ![actividad catalogo](http://prntscr.com/jxr7wb) ![actividad producto](http://prntscr.com/jxr9c3)
> ![actividad login](http://prntscr.com/jxr82c) ![actividad cliente](http://prntscr.com/jxr88c)
> ![actividad recargas](http://prntscr.com/jxr8gr) ![actividad ayuda](http://prntscr.com/jxr8nd)
> ![actividad promociones](http://prntscr.com/jxr7jo)
> ![actividad admincp](http://prntscr.com/jxr9ph) ![actividad admincp lista productos](http://prntscr.com/jxr9vj)

>## RESUMEN HISTORIA DE USUARIO
>| Historia de usuario | Puntos | Terminada |
>|--|--|--|
>| Intro | 1 | Si |
>| Menu principal | 3 | Si |
>| Catalogo | 10 | Si |
>| Detalles Producto | 5 | Si |
>| Login | 8 | Si |
>| Área de Cliente | 10 | No |
>| Recargas | 4 | Si |
>| Ayuda | 4 | Si |
>| Promociones | 8 | Si |
>| AdminCP | 10 | No |
>| AdminCP lista productos | 5 | No |