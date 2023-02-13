# AlgoritmoVisibilidad
Prueba técnica Inditex

-Archivos csv en carpeta resources.

Pruebas unitarias:

![image](https://user-images.githubusercontent.com/24320725/218354529-b3fe921c-7d9c-4cbd-ace2-8438e1250068.png)

Version Java utilizada: 1.8

######Qué estructuras de datos (Listas, Sets, etc) has seleccionado para resolverlo y porque las has considerado como las más adecuadas en cada caso.
He utilizado ArrayList para manejar en memoria los datos leídos de los csv, lo consideré adecuado ya que puede contener objetos, son dinámicos, tiene acceso rápido a través de su índice y se puede recorrer de forma fácil su contenido.

######Una vez resuelto el algoritmo de visibilidad. ¿Qué complejidad temporal expresada en notación “O” crees que tiene? ¿Consideras que se podría mejorar de alguna manera?
Me parece que el algoritmo tiene una complejidad de O(n2) la cual es tratable, esto se podría mejorar relacionando los objetos de los archivos csv leídos o leyendo desde la base de datos con algún quería que obtenga los valores para manejarlos en una sola lista.
