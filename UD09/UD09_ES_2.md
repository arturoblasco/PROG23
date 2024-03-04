---
title: UD10: Acceso a Bases de Datos
language: ES
author: Arturo Blasco Cervera
subject: Programación
keywords: [PRG, 2023, Programacion, Java]
IES: IES Mestre Ramon Esteve (Catadau) [www.iesmre.es]
header: ${title} - ${subject} (ver. ${today}) 
footer:${currentFileName}.pdf - ${author} - ${IES} - ${pageNo}/${pageCount}
typora-root-url:${filename}/../
typora-copy-images-to:${filename}/../assets
---
[toc]

# Introducción

Hoy en día, la mayoría de aplicaciones informáticas necesitan almacenar y gestionar gran cantidad de datos.

Esos datos, se suelen guardar en **bases de datos relacionales**, ya que éstas son las más extendidas actualmente.

Las bases de datos relacionales permiten organizar los datos en **tablas** y esas tablas y datos se relacionan mediante campos clave. Además se trabaja con el lenguaje estándar conocido como **SQL**, para poder realizar las consultas que deseemos a la base de datos.

Una base de datos relacional se puede definir de una manera simple como aquella que presenta la información en tablas con filas y columnas.

Una tabla es una serie de **filas** y **columnas** , en la que cada fila es un **registro** y cada columna es un **campo**. Un campo representa un dato de los elementos almacenados en la tabla (NSS, nombre, etc.). Cada registro representa un elemento de la tabla (el equipo Real Madrid, el equipo Real Murcia, etc.)

No se permite que pueda aparecer dos o más veces el mismo registro, por lo que uno o más campos de la tabla forman lo que se conoce como **clave primaria** (atributo que se elige como identificador en una tabla, de manera que no haya dos registros iguales, sino que se diferencien al menos en esa clave. Por ejemplo, en el caso de una tabla que guarda datos de personas, el número de la seguridad social, podría elegirse como clave primaria, pues sabemos que aunque haya dos personas llamadas, por ejemplo, Juan Pérez Pérez, estamos seguros de que su número de seguridad social será distinto).

El sistema gestor de bases de datos, en inglés conocido como: **Database Management System (DBMS)** , gestiona el modo en que los datos se almacenan, mantienen y recuperan.

En el caso de una base de datos relacional, el sistema gestor de base de datos se denomina: **Relational Database Management System (RDBMS)**.

Tradicionalmente, la programación de bases de datos ha sido como una Torre de Babel: gran cantidad de productos de bases de datos en el mercado, y cada uno “hablando” en su lenguaje privado con las aplicaciones.

Java, mediante **JDBC** ( Java Database Connectivity, API que permite la ejecución de operaciones sobre bases de datos desde el lenguaje de programación Java, independientemente del sistema operativo donde se ejecute o de la base de datos a la cual se accede), permite simplificar el acceso a base de datos , proporcionando un lenguaje mediante el cual las aplicaciones pueden comunicarse con motores de bases de datos. Sun desarrolló este API para el acceso a bases de datos, con tres objetivos principales en mente:

- Ser un API con soporte de SQL: poder construir sentencias SQL e insertarlas dentro de llamadas al API de Java,
- Aprovechar la experiencia de los APIs de bases de datos existentes,
- Ser sencillo.

## desfase objeto-relacional

El desfase objeto‐relacional, también conocido como impedancia objeto‐relacional, consiste en la diferencia de aspectos que existen entre la programación orientada a objetos y la base de datos. Estos aspectos se puede presentar en cuestiones como:

- **Lenguaje de programación**: El programador debe conocer el lenguaje de programación orientada a objetos (POO) y el lenguaje de acceso a datos.
- **Tipos de datos**: en las bases de datos relacionales siempre hay restricciones en cuanto a los tipos de datos que se pueden usar, que suelen ser sencillos, mientras que la programación orientada a objetos utiliza tipos de datos más complejos.
- **Paradigma de programación** (una propuesta tecnológica, un modelo, adoptada por una comunidad de programadores que unívocamente trata de resolver uno o varios problemas claramente delimitados. Tiene una estrecha relación con la formalización de determinados lenguajes en su momento de definición. Un paradigma de programación está delimitado en el tiempo en cuanto a aceptación y uso ya que nuevos paradigmas aportan nuevas o mejores soluciones que la sustituyen parcial o totalmente ). En el proceso de diseño y construcción del software se tiene que hacer una traducción del modelo orientado a objetos de clases al modelo Entidad‐Relación (E/R) puesto que el primero maneja objetos y el segundo maneja tablas y tuplas o filas, lo que implica que se tengan que diseñar dos diagramas diferentes para el diseño de la aplicación.

El modelo relacional trata con relaciones y conjuntos debido a su naturaleza matemática. Sin embargo, el modelo de Programación Orientada a Objetos trata con objetos y las asociaciones entre ellos. Por esta razón, el problema entre estos dos modelos surge en el momento de querer persistir los objetos de negocio

La escritura (y de manera similar la lectura) mediante JDBC implica: abrir una conexión, crear una sentencia en SQL y copiar todos los valores de las propiedades de un objeto en la sentencia, ejecutarla y así almacenar el objeto. Esto es sencillo para un caso simple, pero trabajoso si el objeto posee muchas propiedades, o bien se necesita almacenar un objeto que a su vez posee una colección de otros elementos. Se necesita crear mucho más código, además del tedioso trabajo de creación de sentencias SQL.

Este problema es lo que denominábamos **impedancia Objeto‐Relacional** , o sea, el conjunto de dificultades técnicas que surgen cuando una base de datos relacional se usa en conjunto con un programa escrito con lenguajes de Programación Orientada a Objetos.

Veremos este desfase a lo largo de las actividades.

## Conexión a las BD: Conectores

Dejemos de momento de lado el desfase Objeto-Relacional y centrémonos ahora en el acceso a Base de Datos Relacionales desde los lenguajes de programación. Lo razonaremos en general y lo aplicaremos a Java.

Desde la década de los 80 que existen a pleno rendimiento las bases de datos relacionales. Casi todos los Sistemas Gestores de Bases de Datos (excepto los más pequeños como Access o Base de LibreOffice) utilizan la arquitectura cliente-servidor. Esto significa que hay un ordenador central donde está instalado el Sistema Gestor de Bases de Datos Relacional que actúa como servidor, y habrá muchos clientes que se conectarán al servidor haciendo peticiones sobre la Base de Datos.

Los Sistemas Gestores de Bases de Datos inicialmente disponían de lenguajes de programación propios para poder hacer los accesos desde los clientes. Era muy consistente, pero a base de ser muy poco operativo:

- La empresa desarrolladora del SGBD debían mantener un lenguaje de programación, que resultaba necesariamente muy costoso, si no querían que quedara desfasado.
- Las empresas usuarias del SGBD, que se conectaban como clientes, se encontraban muy ligadas al servidor para tener que utilizar el lenguaje de programación para acceder al servidor, lo que no siempre se ajustaba a sus necesidades. Además, el plantearse cambiar de servidor, significaba que había que rehacer todos los programas, y por tanto una tarea de muchísima envergadura.

Para poder ser más operativos, había que desvincular los lenguajes de programación de los Sistemas Gestores de Bases de Datos utilizando unos estándares de conexión.

## JDBC

**JDBC** es un **API** Java que hace posible ejecutar sentencias **SQL**.

De JDBC podemos decir que:

- Consta de un conjunto de clases e interfaces escritas en Java.
- Proporciona un API estándar para desarrollar aplicaciones de bases de datos con un API Java pura.

Con JDBC , no hay que escribir un programa para acceder a una base de datos Access, otro programa distinto para acceder a una base de datos Oracle, etc., sino que podemos escribir un único programa con el API JDBC y el programa se encargará de enviar las sentencias SQL a la base de datos apropiada. Además, y como ya sabemos, una aplicación en Java puede ejecutarse en plataformas distintas.

En el desarrollo de JDBC, y debido a la confusión que hubo por la proliferación de API’s propietarios de acceso a datos, Sun buscó los aspectos de éxito de un API de este tipo, ODBC ( Open Database Connectivity. API de acceso a datos, desarrollado por Microsoft. con la idea de tener un estándar para el acceso a bases de datos en entorno Windows ).

Aunque la industria ha aceptado ODBC como medio principal para acceso a bases de datos en Windows, ODBC no se introduce bien en el mundo Java, debido a la complejidad que presenta ODBC, y que entre otras cosas ha impedido su transición fuera del entorno Windows.

El nivel de abstracción ( Uno de los objetivos fundamentales de una base de datos es proporcionar a los usuarios una visión abstracta de los datos. Es decir, el sistema oculta ciertos detalles relativos a la forma en que se almacenan y mantienen los datos. Esto se logra definiendo tres niveles de abstracción en los que puede considerarse la base de datos: físico, conceptual y de visión ) al que trabaja JDBC es alto en comparación con ODBC, la intención de Sun fue que supusiera la base de partida para crear librerías de más alto nivel.

JDBC intenta ser tan simple como sea posible, pero proporcionando a los desarrolladores la máxima flexibilidad.

> JDBC es la versión de ODBC para Java.

### Instalación controlador MySql

El primer paso es descargar desde https://www.mysql.com/products/connector/ el conector apropiado.

<img src="https://victorponz.github.io/programacion-java/assets/img/BD/1557844973343.png" alt="1557844973343" style="zoom:67%;" />

<img src="https://victorponz.github.io/programacion-java/assets/img/BD/1557845207905.png" alt="1557845207905" style="zoom: 50%;" />

Haced clic en el enlace **Looking for previous GA versions?**

<img src="https://victorponz.github.io/programacion-java/assets/img/BD/1557847453096.png" alt="1557847453096" style="zoom:50%;" />

Haced clic en Donwload y seleccionad la opción **No thanks, just start download**<img src="https://victorponz.github.io/programacion-java/assets/img/BD/1557845061814.png" alt="1557845061814" style="zoom:50%;" />

Descomprimid el archivo y os quedará la siguiente estructura de directorio:

<img src="https://victorponz.github.io/programacion-java/assets/img/BD/1557847524903.png" alt="1557847524903" style="zoom:67%;" />

Ahora copiad el archivo `mysql-connector-java-5.1.47.jar` en directorio de instalación de Eclipse.

El siguiente paso es configurar Eclipse para que se comunique con **MySql**. En primer lugar hay que haber descargado el archivo `mysql-connector-java-5.1.47.jar`.

El siguiente paso es crear un **New Driver Definition**, desde `Window -> Preferences -> Data Management -> Connectivity -> Driver Definitions` y pulsamos el botón **Add**.

### Agregar la librería a un proyecto Eclipse

Una vez creado el proyecto, hemos de añadir el conector como una **librería externa**, configurando el Build Path

<img src="https://victorponz.github.io/programacion-java/assets/img/BD/1557845704969.png" alt="1557845704969" style="zoom:67%;" />

Y ya tenemos instalada la librería.

<img src="https://victorponz.github.io/programacion-java/assets/img/BD/1557848175572.png" alt="1557848175572" style="zoom:67%;" />

### Instalar driver en IntelliJ

En el caso de IntelliJ lo instalaremos como una dependencia el archivo `pom.xml` que se encuentra en raíz del proyecto, donde añadimos las siguientes líneas:

```xml
<dependencies>
	<!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
	<dependency>
	    <groupId>mysql</groupId>
	    <artifactId>mysql-connector-java</artifactId>
	    <version>8.0.32</version>
	</dependency>
</dependencies>
```

Después pulsamos botón derecho sobre el archivo `pom.xml` y elegimos `maven -> Reload project`

### Instalar driver en BlueJ

En el caso de **BlueJ**, se añaden las librerías desde *Herramientas -> Preferencias -> Librerías*

<img src="https://victorponz.github.io/programacion-java/assets/img/BD/1520962274001.png" alt="1520962274001" style="zoom:67%;" />

### Carga del controlador JDBC y conexión con la BD

El primer paso para conectarnos a una base de datos mediante JDBC es cargar el controlado apropiado. Estos controladores se distribuyen en un archivo `.jar` que provee el fabricante del SGBD y deben estar accesibles por la aplicación, bien porque están en el `CLASSPATH` de java o porque lo tenemos en el mismo directorio que la aplicación.

Para cargar el controlador se usan las siguientes sentencias:

```java
import java.sql.*;
public class ConnectToMySql {
  public static void main(String[] av) {
    try {
      // Dependiendo de a qué tipo de SGBD queramos conectar cargaremos un controlador u otro
      // Intentar cargar el driver de MySQL
      Class<?> c = Class.forName("com.mysql.jdbc.Driver");
      System.out.println("Cargado " + c.getName());
      //Definir la url de conexión y los parámetros de usuario y contraseña
      String host = "jdbc:mysql://localhost:3306/network";
      String username = "root";
      String password = "sa";
      Connection con = DriverManager.getConnection(host, username, password);
      System.out.println("Conexión completada");
      con.close();
    } catch (ClassNotFoundException cnfe) {
      System.out.println(cnfe.getMessage());
	} catch (SQLException ex) {
      System.out.println("Se ha producido un error al conectar: " + ex.getMessage());
    }
  }
}
```

Observamos las siguientes cuestiones:

- Como ya hemos comentado alguna vez, la sentencia `Class.forName()` no sería necesaria en muchas aplicaciones. Pero nos asegura que hemos cargado el driver, y por tanto el `DriverManager` la sabrá manejar
- El `DriverManager` es capaz de encontrar el driver adecuado a través de la url proporcionada (sobre todo si el driver está cargado en memoria), y es quien nos proporciona el objeto `Connection` por medio del método `getConnection()`. Hay otra manera de obtener el `Connection` por medio del objeto `Driver`, como veremos más adelante, pero también será pasando indirectamente por `DriverManager`.
- Si no se encuentra la clase del driver (por no tenerlo en las librerías del proyecto, o haber escrito mal su nombre) se producirá la excepción `ClassNotFoundException`. Es conveniente tratarla con `try ... catch`.
- Si no se puede establecer la conexión por alguna razón se producirá la excepción `SQLException`. Al igual que en el caso anterior, es conveniente tratarla con `try ... catch`.
- El objeto `Connection` mantendrá una conexión con la Base de Datos desde el momento de la creación hasta el momento de cerrarla con `close()`. Es muy importante cerrar la conexión, no sólo para liberar la memoria de nuestro ordenador (que al cerrar la aplicación liberaría), sino sobre todo para cerrar la sesión abierta en el Servidor de Bases de Datos.

> Para que este programa funcione, los jar’s de los drivers deben estar en alguna ruta definida en el `CLASSPATH` de java.

Una manera de conectar alternativa a las anteriores es utilizando el objeto `Driver`. La clase `java.sql.Driver` pertenece a la **API JDBC**, pero no es instanciable, y tan sólo es una interfaz, para que las clases `Driver` de los contenedores hereden de ella e implementen la manera exacta de acceder al SGBD correspondiente. Como no es instanciable (no podemos hacer new Driver()) la manera de crearlo es a través del método `getDriver()` del `DriverManager`, que seleccionará el driver adecuado a partir de la url. Ya sólo quedarán definir algunas propiedades, como el usuario y la contraseña, y obtener el `Connection` por medio del método `connect()`

La manera de conectar a través de un objeto `Driver` es más larga, pero más completa ya que se podrían especificar más cosas. Y quizás ayude a entender el montaje de los controladores de los diferentes SGBD en Java.

```java
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectToMySqlDriver {

    public static void main(String[] args)  {
        String url="jdbc:mysql://localhost:3306/network";
        String username = "root";
        String password = "sa";
		
		try{
		    Driver driver = DriverManager.getDriver(url);

		    Properties properties = new Properties();
		    properties.setProperty("user", username);
		    properties.setProperty("password", password);

		    Connection con = driver.connect(url, properties);
		    System.out.println("Conexión completada a través de Driver");
		    con.close();
		} catch (SQLException ex) {
      		System.out.println("Se ha producido un error al conectar: " + ex.getMessage());
    	}
    }
}
```

> En este caso, sólo funcionará si el driver se encuentra en el `CLASSPATH` o hemos añadido la librería a nuestro IDE

### Carga del controlador y de la conexión mediante el patrón Singleton

Este patrón de diseño está diseñado para restringir la creación de objetos pertenecientes a una clase. Su intención consiste en garantizar que una clase sólo tenga una instancia y proporcionar un punto de acceso global a ella. El patrón `Singleton` se implementa creando en nuestra clase un método que crea una instancia del objeto sólo si todavía no existe alguna. Para asegurar que la clase no puede ser instanciada nuevamente se regula el alcance del constructor haciéndolo privado. Las situaciones más habituales de aplicación de este patrón son aquellas en las que dicha clase ofrece un conjunto de utilidades comunes para todas las capas (como puede ser el sistema de log, conexión a la base de datos, …) o cuando cierto tipo de datos debe estar disponible para todos los demás objetos de la aplicación (en java no hay variables globales) El patrón Singleton provee una única instancia global gracias a que:

- La propia clase es responsable de crear la única instancia.
- Permite el acceso global a dicha instancia mediante un método de clase.
- Declara el constructor de clase como privado para que no sea instanciable directamente.

```java
/**
 * @see <a href="https://stackoverflow.com/questions/6567839/if-i-use-a-singleton-class-for-a-database-connection-can-one-user-close-the-con">Stackoverflow Singleton</a>
 * Patron Singleton
 * ================
 * Este patrón de diseño está diseñado para restringir la creación de objetos pertenecientes a una clase. Su intención consiste en garantizar que
 * una clase sólo tenga una instancia y proporcionar un punto de acceso global a ella.
 * El patrón Singleton se implementa creando en nuestra clase un método que crea una instancia del objeto sólo si todavía no existe alguna.
 * Para asegurar que la clase no puede ser instanciada nuevamente se regula el alcance del constructor haciéndolo privado.
 * Las situaciones más habituales de aplicación de este patrón son aquellas en las que dicha clase ofrece un conjunto de utilidades comunes
 * para todas las capas (como puede ser el sistema de log, conexión a la base de datos, ...)
 * o cuando cierto tipo de datos debe estar disponible para todos los demás objetos de la aplicación.
 * El patrón Singleton provee una única instancia global gracias a que:
 * - La propia clase es responsable de crear la única instancia.
 * - Permite el acceso global a dicha instancia mediante un método de clase.
 * - Declara el constructor de clase como privado para que no sea instanciable directamente.
 */
public class DatabaseConnection
{
    private static DatabaseConnection dbInstance; //Variable para almacenar la unica instancia de la clase
    private static java.sql.Connection con;

    private DatabaseConnection() {
      // El Constructor es privado!!
    }

    public static DatabaseConnection getInstance(){
        //Si no hay ninguna instancia...
        if(dbInstance==null){
            dbInstance= new DatabaseConnection();
        }
        return dbInstance;
    }

    public static java.sql.Connection getConnection(){

        if(con==null){
            try {
                String host = "jdbc:mysql://localhost:3306/network";
                String username = "root";
                String password = "sa";
                con = java.sql.DriverManager.getConnection( host, username, password );
                System.out.println("Conexión realizada");
            } catch (java.sql.SQLException ex) {
                System.out.println("Se ha producido un error al conectar: " + ex.getMessage());
            }
        }

        return con;
    }
}
```

<img src="https://victorponz.github.io/programacion-java/assets/img/BD/1557849184617.png" alt="1557849184617" style="zoom:67%;" />

Vamos a crear una nueva clase para probar la conexión.

```java
import java.sql.*;
public class Test
{
    static java.sql.Connection con = DatabaseConnection.getInstance().getConnection();
    public Test(){
        //De momento no hace nada
    }
}
```

<img src="https://victorponz.github.io/programacion-java/assets/img/BD/1557849470525.png" alt="1557849470525" style="zoom:67%;" />

# acceso a datos

Para escribir sentencias SQL, JDBC dispone de los objetos `Statement`. Se trata de objetos que se han de crear a partir de `Connection`, los cuales pueden enviar sentencias SQL al SGBD conectado para que se ejecutan con el método `executeQuery` o `executeUpdate`.

Hay una variante del `Statement`, llamada `PreparedStatement` que nos da más versatilidad para poner parámetros y ejecutar la sentencia de otro modo. Lo veremos más adelante.

La diferencia entre los dos métodos que ejecutan sentencias SQL es:

- El método `executeQuery` sirve para ejecutar sentencias de las que se espera que devuelven datos, es decir, son consultas **SELECT**.
- En cambio, el método `executeUpdate` sirve específicamente para sentencias que no devuelven datos. Servirán para modificar la Base de Datos conectada (**INSERT**, **DELETE**, **UPDATE**, incluso **CREATE** TABLE).

## Sentencias que no devuelven datos

Las ejecutamos con el método `executeUpdate`. Serán todas las sentencias SQL **excepto el SELECT**, que es la de consulta. Es decir, nos servirá para las siguientes sentencias:

- Sentencias que cambian las estructuras internas de la BD donde se guardan los datos (instrucciones conocidas con las siglas **DDL**, del inglés **Data Definition Language**), como por ejemplo `CREATE TABLE`, `CREATE VIEW`, `ALTER TABLE`, `DROP TABLE`, …,
- Sentencias para otorgar permisos a los usuarios existentes o crear otros nuevos (subgrupo de instrucciones conocidas como **DCL** o **Data Control Language**), como por ejemplo `GRANT`.
- Y también las sentencias para modificar los datos guardados utilizando las instrucciones `INSERT`, `UPDATE` y `DELETE`.

Aunque se trata de sentencias muy dispares, desde el punto de vista de la comunicación con el SGBD se comportan de manera muy similar, siguiendo el siguiente patrón:

1. Instanciación del `Statement` a partir de una conexión activa.
2. Ejecución de una sentencia SQL pasada por parámetro al método `executeUpdate`.
3. Cierre del objeto `Statement` instanciado.

Miremos este ejemplo, en el que vamos a crear una tabla muy sencilla en la Base de Datos MySql/network

> **Nota** En este enlace tenéis la clase [DatabaseConnection](https://gist.github.com/victorponz/34e36ad0ff5585d91952e0edeb23fa49)

<img src="https://victorponz.github.io/programacion-java/assets/img/datos/1558006429758.png" alt="1558006429758" style="zoom:67%;" />

## Sentencias que devuelven datos

Las ejecutamos con el método `executeQuery`. Servirá para la sentencia **SELECT**, que es la de consulta. Los datos que nos devuelva esta sentencia las tendremos que guardar en un objeto de la clase `java.sql.ResultSet`, es decir conjunto de resultado. Por lo tanto, la ejecución de las consultas tendrá un forma similar a la siguiente:

```java
ResultSet rs = st.executeQuery(sentenciaSQL);
```

El objeto `ResultSet` contiene el resultado de la consulta organizado por filas, por lo que en cada momento se puede consultar una fila. Para ir visitando todas las filas de una a una, iremos llamando el método `next()` del objeto `ResultSet`, ya que cada vez que se ejecute `next` avanzará a la siguiente fila. Inmediatamente después de una ejecución, el `ResultSet` se encuentra posicionado justo antes de la primera fila, por lo tanto para acceder a la primera fila será necesario ejecutar `next` una vez. Cuando las filas se acaban, el método `next` devolverá falso.

Desde cada fila se podrá acceder al valor de sus columnas con ayuda de varios métodos `get` disponibles según el tipo de datos a devolver y pasando por parámetro el número de columna que deseamos obtener. El nombre de los métodos comienza por `get` seguido del nombre del tipo de datos. Así, si queremos recuperar la segunda columna, sabiendo que es un dato de tipo `String` habrá que ejecutar:

```java
rs.getInt(1);
```

Las columnas se empiezan a contar a partir del **valor 1** (no cero). La mayor parte de los SGDB soportan la posibilidad de pasar por parámetro el nombre de la columna, pero no todos, así que normalmente se opta por el parámetro numérico.

Por ejemplo MySql sí que deja acceder por nombre, por tanto, suponiendo que el campo 1 se llama ID, también se puede hacer:

```java
rs.getInt("ID");
```

En este ejemplo accedemos a la tabla usuarios y mostramos todos sus registros

<img src="https://victorponz.github.io/programacion-java/assets/img/datos/1558006455182.png" alt="1558006455182" style="zoom:67%;" />

## Asegurar la liberación de recursos

Las instancias de `Connection` y las de `Statement` guardan, en memoria, mucha información relacionada con las ejecuciones realizadas. Además, mientras continúan activas mantienen en el SGBD una sesión abierta, que supondrá un conjunto importante de recursos abiertos, destinados a servir de forma eficiente las peticiones de los clientes. Es importante cerrar estos objetos para liberar recursos tanto del cliente como del servidor.

Si en un mismo método debemos cerrar un objeto `Statement` y el `Connection` a partir del cual la hemos creado, se deberá cerrar primero el `Statement` y después el `Connection`. Si lo hacemos al revés, cuando intentamos cerrar el `Statement` nos saltará una excepción de tipo `SQLException`, ya que el cierre de la conexión le habría dejado inaccesible.

Además de respetar el orden, asegurar la liberación de los recursos situando las operaciones de cierre dentro de un bloque `finally`. De este modo, aunque se produzcan errores, no se dejarán de ejecutar las instrucciones de cierre.

Hay que tener en cuenta todavía un detalle más cuando sea necesario realizar el cierre de varios objetos a la vez. En este caso, aunque las situamos una tras otra, todas las instrucciones de cierre dentro del bloque `finally`, no sería suficiente garantía para asegurar la ejecución de todos los cierres, ya que, si mientras se produce el cierre de un los objetos se lanza una excepción, los objetos invocados en una posición posterior a la del que se ha producido el error no se cerrarán.

La solución de este problema pasa por evitar el lanzamiento de cualquier excepción durante el proceso de cierre. Una posible forma es encapsular cada cierre entre sentencias `try-catch` dentro del `finally`

Aquí tenéis un ejemplo completo:

<img src="https://victorponz.github.io/programacion-java/assets/img/datos/1558006483816.png" alt="1558006483816" style="zoom:67%;" />

## Ejemplos

El siguiente ejemplo permite insertar un usuario en la base de datos:

<img src="https://victorponz.github.io/programacion-java/assets/img/datos/1558006506490.png" alt="1558006506490" style="zoom:67%;" />

Y este sería el mismo método pero pasándole los parámetros nombre y apellidos:

<img src="https://victorponz.github.io/programacion-java/assets/img/datos/1558006521344.png" alt="1558006521344" style="zoom:67%;" />

Como se puede observar, hemos de construir la cadena sql concatenado datos, alternando comillas simples con dobles. Vamos, que si hemos de realizar una consulta con muchos campos, resulta bastante complejo crear la cadena sql y, además, puede llevarnos a errores.

## Sentencias predefinidas

Para solucionar el problema de crear sentencias sql complejas, se utiliza `PreparedStatement`.

JDBC dispone de un objeto derivado del `Statement` que se llama `PreparedStatement`, al que se le pasa la sentencia SQL en el momento de crearlo, no en el momento de ejecutar la sentencia (como pasaba con `Statement`). Y además esta sentencia puede admitir parámetros, lo que nos puede ir muy bien en determinadas ocasiones.

De cualquier modo, `PreparedStatement` presenta ventajas sobre su antecesor `Statement` cuando nos toque trabajar con sentencias que se hayan de ejecutar varias veces. La razón es que cualquier sentencia SQL, cuando se envía al SGBD será compilada antes de ser ejecutada.

- Utilizando un objeto `Statement`, cada vez que hacemos una ejecución de una sentencia, ya sea vía `executeUpdate` o bien vía `executeQuery`, el SGBD la compilará, ya que le llegará en forma de cadena de caracteres.
- En cambio, al `PreparedStament` la sentencia nunca varía y por lo tanto se puede compilar y guardar dentro del mismo objeto, por lo que las siguientes veces que se ejecute no habrá que compilarse. Esto reducirá sensiblemente el tiempo de ejecución.

En algunos sistemas gestores, además, usar `PreparedStatements` puede llegar a suponer más ventajas, ya que utilizan la secuencia de bytes de la sentencia para detectar si se trata de una sentencia nueva o ya se ha servido con anterioridad. De esta manera se propicia que el sistema guarde las respuestas en la memoria caché, de manera que se puedan entregar de forma más rápida.

La principal diferencia de los objetos `PreparedStatement` en relación a los `Statement`, es que en los primeros se les pasa la sentencia SQL predefinida en el momento de crearlo. Como la sentencia queda predefinida, ni los métodos `executeUpdate` ni `executeQuery` requerirán ningún parámetro. Es decir, justo al revés que en el `Statement`.

Los parámetros de la sentencia se marcarán con el símbolo de interrogación (?) Y se identificarán por la posición que ocupan en la sentencia, empezando a contar desde la izquierda a partir del número 1. El valor de los parámetros se asignará utilizando el método específico, de acuerdo con el tipo de datos a asignar. El nombre empezará por `set` y continuará con el nombre del tipo de datos (ejemplos: `setString`, `setInt`, `setLong`, `setBoolean` …). Todos estos métodos siguen la misma sintaxis:

```java
setXXXX(<posiciónEnLaSentenciaSQL>, <valor>);
```

Este es el mismo método para insertar un usuario pero usando `PreparedStatement`:

<img src="https://victorponz.github.io/programacion-java/assets/img/datos/1558006558042.png" alt="1558006558042" style="zoom:67%;" />

Fijaos que ahora, además, la sentencia sql es mucho más fácil de escribir.

## Trabajar con Sqlite

Para poder trabajar en casa, vamos a utilizar Sqlite que es un una base de datos sencilla que se guarda en un único archivo en disco.

Lo primero es instalar SQLite, en Ubuntu

```sh
sudo apt-get install sqlite
```

Si queréis hacerlo en Windows, podéis seguir las instrucciones en http://www.sqlitetutorial.net/download-install-sqlite/

Para poder trabajar en java, hemos de descargar también el conector, desde

http://www.sqlitetutorial.net/sqlite-java/sqlite-jdbc-driver/

Lo primero que hemos de hacer es crear una base de datos, desde la línea de comandos. Para ello nos situamos en el directorio del proyecto y la creamos en el directorio `bd` mediante el siguiente comando:

```sh
cd directorio-del-proyecto
mkdir bd
cd bd
sqlite network.bd
```

Mediante estos comandos creamos una base de datos en disco llamada **network.bd**.

Ahora podemos crear las tablas mediante Eclipse, añadiendo una nueva `DataBaseConnection`, al igual que hicimos con MySql (previamente hemos de crear el `Driver Definition`).

<img src="https://victorponz.github.io/programacion-java/assets/img/datos/1558285490693.png" alt="1558285490693" style="zoom:67%;" />

Y ahora podemos crear las tablas mediante Scrapbook

<img src="https://victorponz.github.io/programacion-java/assets/img/datos/1558285576032.png" alt="1558285576032" style="zoom:67%;" />

```sql
CREATE TABLE usuarios (
 id INTEGER PRIMARY KEY AUTOINCREMENT,
  nombre VARCHAR(50) NOT NULL,
  apellidos VARCHAR(255) NOT NULL
);


CREATE TABLE posts (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  texto VARCHAR(255) NOT NULL,
  likes INTEGER NOT NULL,
  fecha timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  id_usuario INTEGER NOT NULL,
  FOREIGN KEY (id_usuario) REFERENCES usuarios(id)
);


CREATE TABLE comentarios (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  texto VARCHAR(255) NOT NULL,
  fecha timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  id_usuario INTEGER  NOT NULL,
  id_post INTEGER  NOT NULL,
  FOREIGN KEY (id_usuario) REFERENCES usuarios(id),
  FOREIGN KEY (id_post) REFERENCES posts(id)
);
```

Y vamos a añadir el jar que hemos descargado al Build path.

> Nota. No sé por qué motivo pero no funciona si lo hago igual que para MySql

Así que elegimos el jar desde Build Path -> Libraries -> Add External JARs.

<img src="https://victorponz.github.io/programacion-java/assets/img/datos/1558285819653.png" alt="1558285819653" style="zoom:67%;" />

Finalmente pulsamos Apply and Close.

En IntelliJ procedemos de la misma manera que hicimos para instalar el driver de MySql.

```xml
<!-- https://mvnrepository.com/artifact/org.xerial/sqlite-jdbc -->
<dependency>
    <groupId>org.xerial</groupId>
    <artifactId>sqlite-jdbc</artifactId>
    <version>3.40.0.0</version>
</dependency>
```

Y ahora modificamos `DatabaseConnection`

```java
 String host = "jdbc:sqlite:src/main/resources/network";
 con = java.sql.DriverManager.getConnection( host);
```

Y hacemos una prueba para ver si funciona:

<img src="https://victorponz.github.io/programacion-java/assets/img/datos/1558290614137.png" alt="1558290614137" style="zoom:67%;" />

Y este debe ser el resultado:

```
Conexión realizada
1	Janet	Espinosa
```

### Ejemplos

Vamos a crear una pequeña base de datos para Empleados en Sqlite:

| **Num** | **Nom**bre | **Depart**amento | **Edad** | **Sueldo** |
| :------ | :--------- | :--------------- | :------- | :--------- |
| 1       | Andreu     | 10               | 32       | 1000.00    |
| 2       | Bernat     | 20               | 28       | 1200.00    |
| 3       | Claudia    | 10               | 26       | 1100.00    |
| 4       | Damià      | 10               | 40       | 1500.00    |

Primero creamos un nuevo Proyecto en Eclipse llamado `EmpleadosBD` y le añadimos la librería sqlite al build path.

Creamos también la base de datos mediante la línea de comandos:

```sh
cd directorio-del-proyecto
mkdir bd
cd bd
sqlite empleados.bd
```

Copiamos el archivo `DatabaseConnection.java` del anterior proyecto y modificamos la cadena de conexión:

```java
String host = "jdbc:sqlite:./bd/empleados.bd";
con = java.sql.DriverManager.getConnection( host);
```

#### Crear tabla

Creamos una clase `CreateTable` para poder crear la tabla:

<img src="https://victorponz.github.io/programacion-java/assets/img/datos/1558290594573.png" alt="1558290594573" style="zoom:67%;" />

#### Insertar datos

Y creamos otra para insertar datos. Esta vez lo haremos con `PreparedStatement`:

<img src="https://victorponz.github.io/programacion-java/assets/img/datos/carbon.png" alt="1558290468365" style="zoom:60%;" />

Esta es la versión con `Statement`:

<img src="https://victorponz.github.io/programacion-java/assets/img/datos/1558290468365.png" alt="1558290468365" style="zoom:67%;" />

#### Consultar datos

Creamos una clase `getAllEmpleados` que nos devuelva todos los empleados:

<img src="https://victorponz.github.io/programacion-java/assets/img/datos/1558290433130.png" alt="1558290433130" style="zoom:67%;" />

#### Modificar datos

Ahora modificamos los datos. Simplemente aumentamos el sueldo un 5% y modificamos el departamento del empleado 3, poniéndole el departamento 3.

<img src="https://victorponz.github.io/programacion-java/assets/img/datos/1558290448718.png" alt="1558290448718" style="zoom:67%;" />

> **Ejercicio**
>
> Crea una aplicación que nos permita gestionar la base de datos network. Debe tener un menú desde el que se puedan gestionar (Create, Read, Update, Delete) usuarios, posts y comentarios

# repository pattern

> Descarga la base de datos desde [aquí](https://victorponz.github.io/programacion-java/assets/network)

En este tema vamos a aprender a añadir a un proyecto orientado a objetos la persistencia en base de datos, sin usar ninguna tecnología como Hibernate (que lo veremos posteriormente).

Partimos de una aplicación en la que los usuarios pueden escribir Posts y comentar Post hechos por otros usuarios. Por lo que existen tres entidades: Users, Posts y Comments. En la siguiente imagen se muestran estas entidades representadas en una base de datos.

![image-20230413104509607](https://victorponz.github.io/programacion-java/assets/img/poo-tablas/image-20230413104509607.png)

Seguramente, en el ejercicio que habéis hecho en el apartado anterior, cada uno de vosotros habréis implementado la aplicación a su manera.

Pero en programación existen una serie de estándares denominados [Patrones de Diseño](https://refactoring.guru/design-patterns) que debes conocer para poder programar según estos patrones y no reinventar la rueda.

> Nosotros vamos a implementar “**Repository Pattern**” porque también os va a servir para cualquier aplicación tanto web, móvil o de escritorio
>
> Según la documentación de [Android](https://developer.android.com/codelabs/basic-android-kotlin-training-repository-pattern?hl=es-419#0)
>
> > The repository pattern is **a design pattern that isolates the data layer from the rest of the app**. The data layer refers to the part of your app, separate from the UI, that handles the app’s data and business logic, exposing consistent APIs for the rest of your app to access this data.

## Database Connection

Esta es la misma clase del apartado anterior

```java
/*
 * @see <a href="https://stackoverflow.com/questions/6567839/if-i-use-a-singleton-class-for-a-database-connection-can-one-user-close-the-con">Stackoverflow Singleton</a>
 * Patron Singleton
 * ================
 * Este patrón de diseño está diseñado para restringir la creación de objetos pertenecientes a una clase. Su intención consiste en garantizar que
 * una clase sólo tenga una instancia y proporcionar un punto de acceso global a ella.
 * El patrón Singleton se implementa creando en nuestra clase un método que crea una instancia del objeto sólo si todavía no existe alguna.
 * Para asegurar que la clase no puede ser instanciada nuevamente se regula el alcance del constructor haciéndolo privado.
 * Las situaciones más habituales de aplicación de este patrón son aquellas en las que dicha clase ofrece un conjunto de utilidades comunes
 * para todas las capas (como puede ser el sistema de log, conexión a la base de datos, ...)
 * o cuando cierto tipo de datos debe estar disponible para todos los demás objetos de la aplicación.
 * El patrón Singleton provee una única instancia global gracias a que:
 * - La propia clase es responsable de crear la única instancia.
 * - Permite el acceso global a dicha instancia mediante un método de clase.
 * - Declara el constructor de clase como privado para que no sea instanciable directamente.
 */
public class DatabaseConnection
{
    private static DatabaseConnection dbInstance; //Variable para almacenar la unica instancia de la clase
    private static java.sql.Connection con;

    private DatabaseConnection() {
        // El Constructor es privado!!
    }

    public static DatabaseConnection getInstance(){
        //Si no hay ninguna instancia...
        if(dbInstance==null){
            dbInstance= new DatabaseConnection();
        }
        return dbInstance;
    }

    public  static java.sql.Connection getConnection(){

        if(con==null){
            try {
                String host = "jdbc:sqlite:src/main/resources/network";
                con = java.sql.DriverManager.getConnection( host );
                System.out.println("Conexión realizada");
            } catch (java.sql.SQLException ex) {
                System.out.println("Se ha producido un error al conectar: " + ex.getMessage());
            }
        }

        return con;
    }
}
```

## Interfaz IRepository

Vamos a empezar creando la interfaz `IRepository` que han de implementar todas las clases que accedan a datos.

```java
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
public interface IRepository<T> {
    List<T> findAll() throws SQLException;
    T findById(int id) throws SQLException;
    void save(T entity)  throws SQLException;
    void delete(T entity) throws SQLException ;
    T bdToEntity(ResultSet rs) throws SQLException ;
}
```

Fijaos en la notación `<T>`. Esto indica que vamos a usar tipos genéricos. Puede ser cualquier clase de java.

- `findAll()` va a recuperar datos de la base de datos y va a crear una lista de objetos `T`, donde `T`será usuario, post o comentario.
- `findById(int id)` va a recuperar el objeto `T` con dicho `id`
- `save(T entity)` va a guardar el objeto `T` en la base de datos
- `deleteById(User user)` va a borrar el objeto `user` en la base de datos
- `bdToEntity(Resulset s)` va a encargarse de convertir un registro de la base de datos en una clase de tipo `T`, por ejemplo un usuario, un post o un comentario.

## SocialNetworkService

Un servicio es un tipo de clase que gestiona recursos que se usan en cualquier parte de la aplicación. Es este caso estamos definiendo el recurso `java.sql.Connection`

```java
public class SocialNetworkService {

    static  final java.sql.Connection connection = DatabaseConnection.getInstance().getConnection();
    public static java.sql.Connection getConnection(){
        return connection;
    }
}
```

Más adelante lo usaremos en le método `main`

## User

Esta es la clase que va a almacenar los datos de la base de datos. Es una clase `POJO (Plain Old Java Object)`

```java
import java.util.ArrayList;

public class User
{
    private int id;
    private String name;
    private String lastName;

    public User()
    {
        this.name = "";
        this.lastName = "";
        this.id = -1;
    }
    public User(int id, String name, String lastName){
        this.id = id;
        this.name = name;
        this.lastName = lastName;
    }
    public User(String name, String lastName)
    {
        this(-1, name, lastName);
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    @Override
    public String toString(){
        return "ID: " + id + " Name: " + name + " Lastname: " + lastName;
    }

}
```

## UserRepositoryImpl

Esta clase va a ser la que realice el *mapeo* entre la base de datos y los objetos del modelo de datos de tal forma que va a corregir el llamado **desfase objeto-relacional**. Básicamente consiste en convertir los registros de la base de datos en objetos y almacenar en la base de datos los objetos de mi modelo.

```java
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements IRepository<User> {
    private java.sql.Connection con;
    public UserRepositoryImpl(){
        this.con = SocialNetworkService.getConnection();
    }

    /**
     * Se encarga de mapear um registro de la base de datos para converirlo en un objeto User
     * @param rs
     * @return Un objeto User
     * @throws SQLException
     */
    public User bdToEntity(ResultSet rs) throws SQLException {
        return new User(rs.getInt("id"), rs.getString("name"), rs.getString("lastName"));
    }

    /**
     * Consulta todos los registros de la tabla users
     * @return Una lista de objetos User
     * @throws SQLException
     */
    public List<User> findAll() throws SQLException {

        List<User> users = new ArrayList<>();

        Statement st = this.con.createStatement();
        //Ejecutar la consulta, guardando los datos devueltos en un Resulset
        ResultSet rs = st.executeQuery("SELECT * FROM users ORDER BY lastName, name");

        while(rs.next()){
            //Mapeamos el registro de la BD en un User
            User u =  bdToEntity(rs);
            //Añadir el User al conjunto de users
            users.add(u);
        }
        return users;
    }
    //De momento estos tres métodos no hacen nada pero hacen falta para poder probar findAll
    public User findById(int id) throws SQLException {
        return new User();
    }
   public void save(User user) throws SQLException{

    }

    public void delete(User user) throws SQLException {
      
    }
}
```

Para que pueda compilar esta clase es necesario que estén implementados (aunque no hagan nada) todos los métodos de la interfaz `IRepository` por eso el cuerpo del método no hace nada.

## SocialNetwork

Esta clase va a contener el método `main`. De momento vamos a probar que podemos listar los usuarios de la aplicación.

```java
import java.sql.SQLException;
import java.util.List;

public class SocialNetwork {

    public static void main(String[] args) throws SQLException {

        UserRepositoryImpl userRepository = new UserRepositoryImpl();
        List<User> userList = userRepository.findAll();
        for (User u : userList){
            System.out.println(u);
        }
    }
}
```

Y la salida:

```sh
ID: 4 Name: Janet Lastname: Espinosa
ID: 6 Name: Maria Lastname: Gallardo
ID: 3 Name: Andrés Lastname: García
ID: 8 Name: Alberto Lastname: Gracia
ID: 14 Name: Juan Lastname: Imedio
ID: 13 Name: Juan Lastname: Marqués
ID: 18 Name: Pedro Lastname: Martínez
ID: 12 Name: Juan Lastname: María
ID: 23 Name: Juan Pedro Lastname: Pascal
ID: 5 Name: Pepe Lastname: Ponz
```

## UserRepositoryImpl II

Ya podemos finalizar `UserRepositoryImpl` con los métodos que faltan.

```java
/**
 * Busca un usuario por id en la tabla users
 * @param id
 * @return El objeto User o null si no existe
 * @throws SQLException
 */

public User findById(int id) throws SQLException {
    PreparedStatement st = con.prepareStatement("SELECT * FROM users WHERE id = ? ");
    st.setInt(1, id);

    ResultSet rs = st.executeQuery();
    User u = null;
    //Si la consulta devuelve algún resultado ...
    if (rs.next()){
        // ... lo mapeamos a un objeto Usuario
        u = bdToEntity(rs);
    }
    //Devolvemos el Usuario ya mapeado
    return u;
}
```

Devolvemos el `User` si existe en la tabla **users**

```java
/**
     * Guarda el usuario User en la base de datos, insertando si id es distinto de -1 o actualizando aquél
     * registro con dicho id
     * @param user
     * @throws SQLException
     */
public void save(User user) throws SQLException{
    if (user.getId() == -1){
        ResultSet rs;
        PreparedStatement st = null;
        String query = "INSERT INTO users (name, lastName) VALUES (?, ?)";
        //Fijáos en Statement.RETURN_GENERATED_KEYS. Permite recuperar el campo ID autogenerado por MySql
        st = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

        st.setString(1, user.getName());
        st.setString(2, user.getLastName());

        st.executeUpdate();

        //Recuperar el id autogenerado
        rs = st.getGeneratedKeys();
        //Este ResultSet solo puede contener un registro: el ID autogenerado

        if (rs.next()){
            //Ahora ya sabemos cuál es el nuevo id del Usuario
            user.setId(rs.getInt(1));
            System.out.println("Autogenerated ID:  " + user.getId());
        }
    }else{
        PreparedStatement st = con.prepareStatement("UPDATE users SET name = ?, lastName = ? WHERE id = ?");
        st.setString(1, user.getName());
        st.setString(2, user.getLastName());
        st.setInt(3, user.getId());

        st.executeUpdate();
    }

}
```

En esta caso estamos convirtiendo objetos `User` en registros de la base de datos **users**.

```java
/**
 * Elimina de la base de datos el usuario user
 * @param user
 * @throws SQLException
 */
public void delete(User user) throws SQLException {
    PreparedStatement st = con.prepareStatement("DELETE FROM users WHERE id = ?");
    st.setInt(1, user.getId());
    st.executeUpdate();
    st.close();
}
```

Y por último, borramos un objeto de su correspondiente usuario en la base de datos.

> Estos serían los componentes necesarios para implementar el patrón repositorio.
>
> Resumiendo:
>
> - tenemos la interfaz `IRepository`
> - tenemos n clases `POJO`
> - por cada clase `POJO` creamos una clase `nombreDeClaseRepositoryImpl` que implemente la interfaz `IRepository`
> - También creamos la clase `nombreDeClaseController` que se va a encargar de gestionar el interfaz de usuario

## UserController

Por último vamos a implementar una clase llamada `UserController` que nos va a servir como User Interface UI para nuestra aplicación. Esta clase ya no forma parte del patrón repositorio y pasaría a forma parte más bien del patrón [Model View Controller](https://www.freecodecamp.org/news/the-model-view-controller-pattern-mvc-architecture-and-frameworks-explained/) (MVC) pues esta clase se encarga de la parte Controller (y en este caso, también View)

```java
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class UserController {

    /**
     * Imprime por pantalla todos los usuarios
     * @throws SQLException
     */
    public static void prinAllUsers() throws SQLException {
       
        UserRepositoryImpl userRepository = new UserRepositoryImpl();
        List<User> users = userRepository.findAll();
        for (User user : users){
            System.out.println(user);
        }
        
    }
    /**
     * Muestra una interfaz  de usuario para añadir un usuario
     * @throws SQLException
     */
    public static void addUser() throws SQLException{
        UserRepositoryImpl userRepository = new UserRepositoryImpl();
        Scanner sc = new Scanner(System.in);
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Lastname: ");
        String lastName = sc.nextLine();
        User user = new User(name, lastName);
        userRepository.save(user);
    }

    /**
     * Muestra la UI para modificar un usuario
     * @throws SQLException
     */
    public static void modifyUser() throws SQLException{
        UserRepositoryImpl userRepository = new UserRepositoryImpl();
        prinAllUsers();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter User id to modify: ");
        int userId = sc.nextInt();
        sc.nextLine();
        System.out.print("New name: ");
        String name = sc.nextLine();
        System.out.print("New lastname: ");
        String lastName = sc.nextLine();
        userRepository.save(new User(userId, name, lastName));
    }

    /**
     * Muestra la UI para borrar un usuario.
     * @throws SQLException
     */
    public static void deleteUser() throws SQLException{
        UserRepositoryImpl userRepository = new UserRepositoryImpl();
        prinAllUsers();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter user id to delete: ");
        User user = userRepository.findById(sc.nextInt());
        userRepository.delete(user);
    }
}
```

En los métodos `addUser`, `updateUser` y `deleteUser` se piden datos por pantalla y se llama al método del repositorio correspondiente: `userRepository.save` o `userRepository.delete`

## Posts

> Crea las clases necesarias para poder trabajar con la entidad `Post`. Como ayuda, ten en cuenta que esta entidad tiene un objeto de la clase `User` que deberás recuperar mediante `new UserRepositoryImpl().findById(rs.getInt("userId"))`
>
> Lo más complicado será la parte `1` en `User` ya que debe tener un método que fije los `Post` de dicho usuario.
>
> En principio sería tan fácil como hacer en el método `bdToEntity` de `UserRepositoryImpl`
>
> ```java
>  PostRepositoryImpl repository = new PostRepositoryImpl();
>  user.setPosts(repository.findByUser(user));
> ```
>
> Pero esto provoca un error en tiempo de ejecución `StackOverflow` debido a que entra en un bucle infinito ya que el método `bdToEntity` llama a `findByUser` que a su vez llama a `bdToEntity` y así hasta el infinito.
>
> La solución es guardar los elementos en caché: cada vez que convierto una entidad a objeto la guardo en esta caché. Cuando debo mapear algún registro primero miro en caché y devuelvo la entidad o mapeo si no existe la entidad.
>
> Creamos una variable de instancia en cada Repositorio. Por ejemplo para UserRepositoryImpl
>
> ```java
> private Set<User> usersCached = new HashSet<>();
> ```
>
> Creamos un método para comprobar si está en caché:
>
> ```java
> private User getUserCached(int i){
> for(User user : usersCached){
>      if (user.getId() == i) return user;
>  }
>  return null;
> }
> ```
>
> Que usamos en `bdToEntity`
>
> ```java
> public User bdToEntity(ResultSet rs) throws SQLException {
>     User user = getUserCached(rs.getInt("id"));
>     if (user == null) {
>         user = new User(rs.getInt("id"), rs.getString("name"), rs.getString("lastName"));
>         usersCached.add(user);
>         PostRepositoryImpl repository = new PostRepositoryImpl();
>         user.setPosts(repository.findByUser(user));
>     }
>     return user;
> }
> ```



> No creáis que en la práctica es tan complicado. Para eso están los frameworks ORM (Object Relational Mapping) que nos facilitan mucho la vida y ellos mismos ya tratan todo el tema de cachés, repositorios, CRUD, etc. Este apartado es simplemente para que creéis desde cero un mini framework.
>
> Seguramente en la empresa utilizaréis Hibernate, Spring Boot, Doctrine, …



> **Comments**
>
> Ahora ya puedes implementar la gestión del los comentarios.

# Píldoras informáticas relacionadas

- https://www.youtube.com/playlist?list=PLNjWMbvTJAIjLRW2qyuc4DEgFVW5YFRSR
- https://www.youtube.com/playlist?list=PLaxZkGlLWHGUWZxuadN3J7KKaICRlhz5-

# Fuentes de información

- [Wikipedia](https://es.wikipedia.org)
- [Programación (Grado Superior) - Juan Carlos Moreno Pérez (Ed. Ra-ma)](https://www.ra-ma.es/libro/programacion-grado-superior_48302/)
- Apuntes IES Henri Matisse (Javi García Jimenez?)
- Apuntes AulaCampus
- [Apuntes José Luis Comesaña](https://www.sitiolibre.com/)
- [Apuntes IOC Programació bàsica (Joan Arnedo Moreno)](https://ioc.xtec.cat/materials/FP/Recursos/fp_asx_m03_/web/fp_asx_m03_htmlindex/index.html)
- [Apuntes IOC Programació Orientada a Objectes (Joan Arnedo Moreno)](https://ioc.xtec.cat/materials/FP/Recursos/fp_dam_m03_/web/fp_dam_m03_htmlindex/index.html)
- [FXDocs](https://github.com/FXDocs/docs)
- https://openjfx.io/openjfx-docs/

