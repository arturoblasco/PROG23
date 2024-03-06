---
  unit: UD07
  title: Ejercicios
  language: ES
  author: Arturo Blasco Cervera [arturoblasco@iesmre.com]
  subject: Programación
  keywords: [PRG, 2023, Programacion, Java]
  IES: IES Mestre Ramón Esteve (Catadau) [iesmre.es]
  header: ${title} - ${subject} (ver: ${today})
  footer:${currentFileName}.pdf - ${author} - ${IES} - ${pageNo}/${pageCount}
  typora-root-url:${filename}/../
  typora-copy-images-to:${filename}/../assets
---




[TOC]



# Ejercicios

(**ejercicio 1**: package **Varios**) Diseñar la clase Varios con los siguientes métodos **estáticos** que se harán apoyándose en alguna clase de las vistas al estudiar las colecciones de Java:

- **`int[] quitarDuplicados (int[] v)`**, que dado un array de enteros devuelva otro array con los mismos valores que el original pero sin duplicados.
- **`int[] union1(int[] v1, int[] v2)`**, que dados dos arrays v1 y v2 devuelva otro array con los elementos que están en v1 o que están en v2, sin que ningún elemento se repita.
- **`int[] unión2(int v1[], int v2[])`**, que dados dos arrays v1 y v2 devuelva otro array con los elementos que están en v1 o que están en v2. En este caso, si hay elementos duplicados se mantendrán.
- **`int[] interseccion(int v1[], int v2[])`**, que dados dos arrays v1 y v2 devuelva otro array con los elementos que aparecen en los dos arrays. Cada elemento común aparecerá una sola vez en el resultado.
- **`int[] diferencia1 (int v1[], int v2[])`**, que dados dos arrays v1 y v2 devuelva otro array con los elementos que de v1 que no están en v2. En caso de haber elementos duplicados en v1 estos se mantendrán en el resultado.
- **`int[] diferencia2 (int v1[], int v2[])`**, que dados dos arrays v1 y v2 devuelva otro array con los elementos de v1 que no están en v2. El array resultante no tendrá elementos duplicados.

(**ejercicio 2**: package **Biblioteca**) Se quiere hacer una aplicación en la que los usuarios van a hacer búsquedas de libros para saber si se  encuentran en los fondos de la biblioteca. El funcionamiento básico sería algo así: Al iniciarse la aplicación todo el catálogo de libros se cargaría en memoria y a partir de ese momento los usuarios pueden realizar búsquedas por título, que interesa que sean lo más rápidas posibles. Nunca se insertan nuevos libros durante la ejecución de la aplicación.

 a) Diseña la clase **`Libro`** con los métodos que consideres oportunos y los siguientes atributos:

- `Titulo` (String): es el dato que identifica al libro.
- `Autor` (String): autor del libro.
- `Estantería` (String): estantería de la biblioteca en la que se encuentra el libro.

b) Diseña la clase **`CatalogoLibros`** como una colección de libros. Utiliza el tipo de colección que crees que más se ajusta a los requisitos de la aplicación justificando la elección. Implementa los siguients métodos:

- `public CatalogoLibros(Libro v[])`: constructor. Para simplificar, inicializa el catálogo y lo rellena con los libros del array v, en lugar de obtenerlos de un fichero.

- `public String buscar(Libro l)`: dado un libro, lo busca en el Catálogo y devuelve la estantería en la que se encuentra el libro o null si el libro no está en el Catálogo.







(**ejercicio 3**: package **Academia**) Se quiere diseñar una clase `Academia`. De una Academia se conoce  su *nombre*, *dirección* y las *Aulas* que tiene (necesitas también generar la clase `Aula`).  

  Definir la clase Academia utilizando una **Collection** para almacenar las aulas. El tipo de colección a utilizar se decidirá teniendo en cuenta que éstas se quieren mantener ordenadas según el criterio del método compareTo de la clase Aula. Implementar los atributos, el constructor, y los siguientes métodos:

  - `void ampliar (Aula a)`, que añade un aula a la academia.

  - `void quitar (Aula a)`, que elimina un aula de la academia.

  - `int getNumAulas()`, que devuelva el número de aulas que tiene.  

  - `toString()`, que muestre todas las aulas de la academia.

    

(**ejercicio 4**: paquete **ListaEspera**) Deseamos mantener la lista de espera de pacientes de un hospital. Se quiere poder:

- Añadir pacientes a la lista.
- Mantener los pacientes por orden de inserción en la lista de espera.
- Obtener el paciente más prioritario (al que hay que atender de la lista de espera), es decir, el que más tiempo lleva esperando, el que antes entró en el hospital.

   a) Diseña la clase `Paciente` con los atributos nombre y gravedad. La gravedad es un valor aleatorio (entre 1: más grave y 5: menos grave) generado al crear el paciente.

   b) Realiza la implementación de la clase `ListaEspera` con la estructura de datos elegida. Añade los métodos para insertar un paciente, obtener de la lista de espera al más prioritario y eliminar de la lista de espera al más prioritario. 

​	¿*Qué tipo de estructura de datos utilizaríamos para almacenar los pacientes, un `List`, `Set` o `Map`*? Justifica la respuesta mediante un comentario arriba de la implementación de esta clase (puntos a favor de la que elijes y en contra de las que descartas).

 c) Implementa una `ListaEsperaPorGravedad`, en la que se atienda primero a los pacientes más graves, independientemente de si llegaron antes o después.  



(**ejercicio 5**: paquete **DiccionarioIngEsp**) 

  a) Diseñar la clase `DiccionarioBilingüe` para almacenar pares formados por:

- Palabra en castellano.
- Colección de traducciones a ingles.

  b) La clase dispondrá de los siguientes métodos:

- constructor: crea el diccionario vacio.

- `anyadirTraduccion(String cast, String ingl)`: añade la pareja (cast, ingl) al diccionario de forma que:
  - Si la palabra cast no estaba en el diccionario la añade, junto con su traducción.
  - Si la palabra cast estaba ya en el diccionario pero no aparecía como traducción la palabra *ing,* añade *ing* a su colección de traducciones.
  - Si la palabra cast estaba y la traducción *ing* también, no se realizarán cambios.
  - El método devuelve true si se han realizado cambios en el diccionario y false en caso contrario.

- `quitarTraduccion(String cast, String ingl)`: quita la traducción *ingl* a la palabra *cast.* Si la palabra en castellano se queda sin traducciones, se elimina del dicicionario. Si se han producido cambios se devuelve true y en caso contrario false.

- `traduccionesDe(String cast)`: devuelve una colección con las traducciones de la palabra indicada o null si la palabra no está en el diccionario.

- `toString()`: devuelve un String con las palabras del diccionario y sus traducciones.  

- clase  `RepeticionPalabras` : escribe un programa que abra el fichero de texto que indique el usuario y muestre cuántas veces se repite cada palabra que contiene. Ayudarse de un Map. ¿Se podría resolver con un Set? ¿Y con un List?
- clase `TraductorSimple` : escribir un programa que solicite al usuario una frase y la muestre traducida a inglés, palabra a palabra. Para ello, se dispone de un fichero palabras.txt que contiene parejas (palabra en español, palabra en inglés) separadas por un tabulador. Cada pareja se encuentra en una línea del fichero. El proceso será el siguiente:
  - Leer el fichero y cargar sus datos en una estructura de datos adecuada. Tener en cuenta que nos interesará buscar una palabra en castellano y obtener su correspondencia en inglés.
  - Solicitar al usuario una frase. Traducir, usando la estructura de datos anterior, cada palabra de la frase y formar con ellas la frase traducida.
  - Mostrar la frase traducida al usuario.

  

(**ejercicio 6**: paquete  **`ListaAdmitidos`**) Una serie de personas han solicitado realizar un curso de inglés. De las que han sido admitidas se quiere almacenar su *nif*, su *nombre* y su *nivel* en un `HashSet`. En el `HashSet` se almacenarán objetos de la clase `Inscripción`.

- Implementa la clase `Incripción` para representar el nif, nombre y nivel de un solicitante. Además de los atributos implementa aquellos métodos que consideres necesarios.

- Escribe un programa (clase `ComprobarAdmision`) que:  

  - Defina un `HashSet` de Inscripciones, llamado `admitidas`.

  - Añada varias inscripciones (invéntate los datos).

  - Permita al usuario introducir un dni para comprobar si la persona indicada ha sido admitida. Indicarle si aparece o no en la lista y, en caso afirmativo, mostrar el nombre y el nivel en que ha sido admitido.
  
  

(**ejercicio 7**: clase **`PalabrasOrdenadas`**) Escribe un programa que, dado un fichero de texto cuya ubicación indica el usuario, muestre sus palabras ordenadas ascendentemente y, después, descendentemente. Cada palabra se mostrará una sola vez, aunque en el texto aparezca varias. 







(**ejercicio 8**: paquete **`EquipoDeFutbol`**) Crear una clase **Futbolista** con los siguientes atributos y métodos:

- Atributos:

   - `Nombre`: nombre del futbolista

   - `Edad`: edad del futbolista

   - `Posición`: Posición que ocupa en el campo el futbolista. Será un tipo
      enumerado. Podrá ser cualquiera de las siguientes: Portero, Defensa, Centrocampista, Delantero. Cada posición tendrá asociada un salario máximo y
      un salario mínimo).
      - Portero, entre 2000 y 3000 euros.
      - Defensa, entre 2500 y 3500 euros.
      - Centrocampista, entre 3500 y 4000 euros.
      - Delantero, entre 4000 y 5000 euros.

- Métodos:

   - getters y setters.
   - `toString()`: imprimirá la información asociada al Futbolista.

b) Además Futbolista implementará la interfaz **Deportista**. Esta interfaz poseerá los siguientes métodos:

- `getAnyosProfesional` : retorna el número de años que un deportista ha estado compitiendo en nivel profesional.
- `getListadoEquipos` : devuelve un listado con el nombre de todos los equipos en los que ha estado el deportista.
- `getTotalTrofeos` : obtiene el total de trofeos conseguidos por el deportista.

c) También se debe crear una clase **Equipo** que tenga como atributos:

- `Nombre`: nombre del equipo
- `Listado de Futbolistas`. Listado de futbolistas del equipo
- Y se deberá controlar el número máximo de futbolistas por posición. Que serán los que a continuación se definen:
   - Portero: 2 como máximo.
   - Defensa: 5 como máximo.
   - Centrocampista: 5 como máximo.
   - Delantero: 4 como máximo.

​	Además, constará de los siguientes métodos:

- `agregarFutbolista` : añadirá un futbolista al equipo siempre que la posición de este no esté completa. En caso contrario lanzará una excepción de tipo `RegistroFutbolistaException`.

- `listarFormaciónDelEquipo` : listará todos los miembros del equipo ordenados por
   posición. Se mostrarán en el siguiente orden:

   - Porteros, Defensas, Centrocampistas, Delanteros.

   La gestión se hará en dos pasos:

   - Primero generaremos el listado ordenado, para ello utilizaréis el método sort asociado al ArrayList, y deberéis sobreescribir el método compare.
   - Luego recorreremos este con un *iterator* y mostraremos la información de cada elemento.
   

d) Respecto a la clase Aplicación `TestEquipo`, simplemente crear un equipo y añadir futbolistas de diferente tipo, generar una solución dónde se pruebe todo lo implementado. Es decir, el hecho de superar el número máximo de futbolistas en cada posición en cada equipo y también que se vea el funcionamiento del método que ordena.



(**ejercicio 9**: paquete **`SistemaAnalisisTextos`**) Crear un sistema de análisis de texto que permita procesar y analizar cadenas de texto utilizando conceptos avanzaeos de colecciones en JAVA.

  a) Crea una clase de  nombre `AnalizadoDeTexto` que contenga los siguientes atributos y métodos:
- atributos:
    - texto (String)
    - palabras (HashMap<String, Integer>)
- métodos:
    - constructor: que reciba el texto a analizar e inicialice el atributo `texto`.
    - `contarPalabras()`: método que procese el texto, cuente la frecuencia de cada palabra y almacene los resultado en el atributo `palabras`. Ignora las diferencias entre mayúsculas y minúsculas.
    - `palabrasMasFrecuentes(int n)`: método que devuelva una lista de las `n` palabras más frecuentes en ele texto, junto con su frecuencia.
    - `palabrasMenosFrecuentes(int n)`: método que devuelva una lista de las `n` palabras menos frecuentes en ele texto, junto con su frecuencia.
    - `palabrasPorLongitud()`: método que devuelva un mapa (HashMap) en el que las claves sean las longitudes de las palabras y los valores sean listas (ArrayList) de palabras que tengan esa longitud. Ordena las listas de palabras alfabéticamente.

 b) Realiza pruebas en un main `TestAnalizadorDeTexto`:
- Crea una instancia de un objeto de la clase `AnalizadoDeTexto` con un texto de prueba.
- Ejecuta el método `contarPalabras()` para procesar el texto.
- Muestra las palabras más y menos frecuentes utilizando los métodos `palabrasMasFrecuentes(int n)` y `palabrasMenosFrecuentes(int n)`.
- Muestra las palabras agrupadas por su longitud utilizando el método `palabrasPorLongitud()`.

# Actividades

**Actividad 1**. Realizar las siguientes actividades relacionadas con `ArrayList`.

- Crear un `ArrayList` de enteros llamado misNumeros.
- Añadir los valores 1, 6, 3, 2, 0, 4, 5.
- Mostrar los datos del `ArrayList`.
- Mostrar el valor de la posición 5.
- Añadir el valor 8 en la posición 4.
- Cambiar el valor de la posición 1 por 9.
- Eliminar el valor 5. (`misNumeros.remove(new Integer(5))` )
- Eliminar el valor de la posición 3.
- Recorrer el array con un bucle for.
- Recorrer el array con un bucle `Iterator`.
- Comprobar si existe el elemento 0.
- Comprobar si existe el elemento 7.
- Clonar el `ArrayList` `misNumeros` en otro llamado `copiaArrayList`.
- Añadir el elemento 9.
- Mostrar la posición de la primera ocurrencia del elemento 9.
- Mostrar la posición de la última ocurrencia del elemento 9.
- Borrar todos los elementos del `ArrayList` `copiaArrayList`.
- Comprobar si el `ArrayList` `copiaArrayList` está vacio.
- Convertir el `ArrayList` `misNumeros` en un `Array` y recorrerlo con un bucle mejorado.

**Actividad 2**. Un cine precisa una aplicación para controlar las personas de la cola para los estrenos de películas. Debemos crear una lista con la edad de las personas de la cola y tendremos que calcular la entrada según la edad de la persona (mínimo 5 años). Para la edad de la persona se generan aleatoriamente números entre 5 y 60 años. Al final, deberemos mostrar la cantidad total recaudada. El número de personas de la cola se elige al azar entre 0 y 50.

La lista de precios se basa en la siguiente tabla.

| EDAD               | PRECIO |
| ------------------ | ------ |
| Entre 5 y 10 años  | 5 €    |
| Entre 11 y 17 años | 7.5 €  |
| Mayor de 18 años   | 9.5 €  |

Como comprobación imprime el número de personas, el precio total y la lista de edades. Por ejemplo:

```sh
Hay un total de 6 personas en la cola.
El precio total es de 57,00 euros
[18, 36, 50, 35, 28, 55]
```

**Actividad 3**. Un supermercado nos pide que hagamos una aplicación que almacene los productos comprados. La aplicación debe almacenar Productos (clase) y cada producto al crearse contiene una cantidad, un precio. 

El nombre del producto será básico (producto1, producto2, producto3, etc.). 

La cantidad y el precio se generan automáticamente.

Calcular el precio total de una lista de entre 1 y 10 productos (aleatorio).

Mostrar un ticket con todo lo vendido y el precio final.

**Actividad 4**. Desarrollar un sistema de gestión de pacientes. Tendremos un archivador dónde iremos guardando todas las fichas de los pacientes. Las fichas contienen la siguiente información: nombre, apellidos y edad.

Todas las fichas que vayamos creando, se podrán guardar o eliminar del archivador. Al archivador también le podremos pedir un listado. Este listado consistirá en visualizar por pantalla el número de fichas guardadas, así como el contenido de las fichas.

La clase `GestionPacientes` tiene un método `main` en el que se crea un archivador, dos o tres fichas que se guardarán en el archivador, se listará el contenido, se eliminará alguna ficha y se volverá a listar su contenido. Todas las clases se guardarán en el paquete `gestionpacientes`.

**Actividad 5**. Crear una estructura `Map` llamada divisas, que almacene pares de moneda y valor al cambio en euros. Por ejemplo Dólar: 0,81€.

- Añadir los siguientes pares moneda/valor al Map divisas:

  | Moneda          | Valor en € |
  | --------------- | ---------- |
  | Dólar Americano | 0.81       |
  | Franco Suizo    | 0.85       |
  | Libra Esterlina | 1.14       |
  | Corona Danesa   | 0.13       |
  | Peso Mexicano   | 0.04       |
  | Dólar Singapur  | 0.62       |
  | Real Brasil     | 0.24       |

- Mostrar el valor de la Libra Esterlina.

- Mostrar todas las divisas con las que se opera y su valor.

- Indicar el número de divisas del Map.

- Eliminar la divisa Real Brasil y mostrar los datos del Map.

- Mostrar si existe la divisa Peso Mexicano.

- Mostrar si existe la divisa Euro.

- Mostrar si existe el valor al cambio 0.85 €.

- Mostrar si existe el valor al cambio 0.33 €.

- Indicar si el Map divisas está vacío.

- Borra todos los componentes del Map divisas.

- Volver a indicar si el Map divisas está vacío.

# Ejercicios Genericidad

1. Crear una clase Genericos (proyecto Genéricos, paquete Genericos) que incorpore los métodos genéricos que se indican a continuación. Los métodos creados serán *public* *static.* En el proyecto se creará además la clase o clases necesarias para probar los métodos desarrollados.

   1. `Object minimo (Object o1, Object o2)`, que devuelva el mínimo de dos objetos cualesquiera (que se suponen del mismo tipo). Una vez desarrollado, prueba el método para obtener el mínimo de dos objetos Integer. Pruébalo también para obtener el mínimo entre un Objeto Integer y un objeto String. En éste último caso, el programa ¿da error de ejecución? Si es así, explica por qué.
   2. `Object maximo (Object o1, Object o2)`, que devuelva el maximo de dos objetos cualesquiera (que se suponen del mismo tipo).
   3. `Object minimo (Object v[])`, que devuelva el mínimo de un array de objetos cualesquiera (que se suponen del mismo tipo). Al respecto de éste último comentario, ¿Se puede poner en un array de Object objetos de distinto tipo, como por ejemplo Strings, Integer, ...? En caso afirmativo, ¿funcionaría el método desarrollado con un array construido así?
   4. `Object maximo (Object v[])`, que devuelva el maximo de un array de objetos cualesquiera (que se suponen del mismo tipo).
   5. `int numVeces(Object v[], Object x)` que devuelva el el numero de apariciones del objeto x en el array v.
   6. `int numVecesOrdenado(Object v[], Object x)` que devuelva el el numero de apariciones del objeto x en el array v **ordenado ascendentemente**.
   7. `int mayores(Object v[], Object x)` que, dado un array de Object v y un Object x devuelva el número de elementos de v que son mayores que x.
   8. `int mayoresOrdenado(Object v[], Object x)` que, dado un array de Object v **ordenado ascendentemente** y un Object x devuelva el número de elementos de v que son mayores que x.
   9. `int menores(Object v[], Object x)` que, dado un array de Object v y un Object x devuelva el número de elementos de v que son menores que x.
   10. `int menoresOrdenado(Object v[], Object x)` que, dado un array de Object v **ordenado ascendentemente** y un Object x devuelva el número de elementos de v que son menores que x.
   11. `boolean estaEn(Object v[], Object x)` que devuelva true si el Objeto x está en el array v.
   12. `boolean estaEnOrdenado(Object v[], Object x)` que devuelva true si el Objeto x está en el array v, **ordenado ascendentemente**.
   13. `int posiciónDe(Object v[], Object x)`, que devuelva la posición que ocupa x dentro del array v, o -1 si x no está en v.
   14. `int posicionDeOrdenado(Object v[], Object x)`, que devuelva la posición que ocupa x dentro del array v **ordenado ascendentemente**, o -1 si x no está en v.
   15. `boolean estaOrdenado(Object v[])`, que devuelva true si el array está ordenado ascendentemente.

2. (Proyecto Genericos, paquete Nevera) Se quiere crear una aplicación que controla una nevera inteligente de última generación. Los alimentos que contiene la nevera se van a representar como objetos de la clase `Alimento` y la clase `NeveraInteligente`, tiene un array de Alimentos entre sus atributos privados.

   **Se pide** implementar la clase **Alimento** teniendo en cuenta que uno de los métodos de NeveraInteligente necesitará ordenar **por calorías** los Alimentos que contiene la nevera utilizando un método de Ordenación genérico. El diseño de la clase Alimento ha de incluir, por tanto, determinados elementos que lo permitan. La clase Alimento tendrá únicamente dos atributos (privados): nombre y calorias.

3. (Proyecto Genericos, paquete Academia) Se quiere diseñar una clase *Academia* . De una Academia se conoce su nombre, dirección y las *Aulas* que tiene (*Aula* es una clase implementada en un ejercicio de herencia que ya hicimos). 

   1. Definir la clase `Academia` utilizando una colección (que permita ordenación) para almacenar las aulas.: Implementar los atributos, el constructor, y los siguientes métodos:
      - `void ampliar (Aula a)`, que añade un aula a la academia.
      - `void quitar (Aula a)`, que elimina un aula de la academia.
      - `int getNumAulas()`, que devuelva el número de aulas que tiene. 
      - método `toString()`
   2. Realiza en la clase `Aula` los cambios necesarios para que se pueda ordenar las aulas de la Academia usando un método genérico de ordenación. El orden sería creciente por capacidad del aula., y a igual capacidad primero las aulas de mayor superficie
   3. Añade a la clase `Academia` un método `ordenar` que ordene las aulas con el criterio especificado. Para realizar la ordenación se llamará a un método de ordenación.

4. (Proyecto Genericos, paquete Conjuntos)

   1. Diseñar un **interface** ***Conjunto*** para modelizar conjuntos de elementos. Diseñar (solo la cabecera) de los siguientes métodos de la clase conjunto (prestar atención a si los métodos deben ser *static* o no):

      - `Añadir`, que añade un elemento al conjunto, provocando la excepción `ElementoDuplicado` si el elemento ya estaba en el conjunto.
      - `Quitar`, que elimina el elemento indicado al conjunto. Provoca `ElementoNoEncontrado` si el elemento indicado no estaba en el conjunto.
      - `Intersección`¸ que dados dos conjuntos que recibe como parámetro devuelve un tercer conjunto que es la intersección de los dos dados.

      - `Pertenece`¸ que dado un elemento devuelve si este pertenece o no al conjunto.

   2. Diseñar una clase `ConjuntoArray` que implemente el interface `Conjunto`. Esta clase implementará los métodos del interface `Conjunto`. Para ello utilizará un array `Object elementos[]` y un `int numElementos`, de manera que los elementos del conjunto se mantendrán almacenados en el array. Además de los métodos del interface habrá que crear un constructor para la clase y también vendrá bien tener un método `toString` para poder probarla.

      NOTA: También lo puedes implementar con una Colección de las vistas en el tema anterior.

# Fuentes de información

- [Wikipedia](https://es.wikipedia.org)
- [Programación (Grado Superior) - Juan Carlos Moreno Pérez (Ed. Ra-ma)](https://www.ra-ma.es/libro/programacion-grado-superior_48302/)
- Apuntes IES Henri Matisse (Javi García Jimenez?)
- Apuntes AulaCampus
- [Apuntes José Luis Comesaña](https://www.sitiolibre.com/)
- [Apuntes IOC Programació bàsica (Joan Arnedo Moreno)](https://ioc.xtec.cat/materials/FP/Recursos/fp_asx_m03_/web/fp_asx_m03_htmlindex/index.html)
- [Apuntes IOC Programació Orientada a Objectes (Joan Arnedo Moreno)](https://ioc.xtec.cat/materials/FP/Recursos/fp_dam_m03_/web/fp_dam_m03_htmlindex/index.html)
- [Apuntes Lionel](https://github.com/lionel-ict/ApuntesProgramacion)