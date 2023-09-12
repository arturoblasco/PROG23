---
unit: UD00
title: Cómo usar el VSCode integrado en GitHub 
language: ES
author: Arturo BC
subject: Programación
keywords: [Markdown, PROG, 2022, Programación]
IES: IES Mestre Ramón Esteve (Catadau) [iesmre.es]
header: ${unit}: ${title} - ${subject} (ver: ${today})
footer: ${currentFileName}.pdf - ${author} - ${IES} - ${pageNo}/${pageCount}
typora-root-url: ${filename}/../
typora-copy-images-to: ${filename}/../assets
---
[toc]
# `VsCode` integrado en `GitHub`

## Localizar repositorio

Primero localizamos el repositorio con el que queremos colaborar:

1. Buscamos al usuario (En todo `GitHub`):

<img src="assets/vscode_01_localizar_repositorio.png" alt="Localizar repositorio" style="zoom:50%;" />

2. Elegimos la pestaña `Repositorios` y después el repositorio en cuestión:

<img src="assets/vscode_02_localizar_repositorio.png" alt="Localizar repositorio 2" style="zoom:50%;" />



## Abrir `VSCode` integrado

Github cuenta con un editor online muy potente basado en `VSCode`.

Una vez visualizamos el código del repositorio en cuestión:

<img src="assets/vscode_03_codigo.png" alt="Screenshot_20220106_171327" alt="Código" style="zoom:50%;" />

para abrir el editor solo debemos pulsar la tecla "." (punto) de nuestro teclado:

<img src="assets/vscode_05_vscode1.png" alt="editor VSCode" style="zoom:50%;" />

Visualizaremos la estructura de carpetas y archivos en un editor `VSCode` integrado en el navegador Web.



## Modificar un archivo

Una vez detectada la errata dentro del código [markdown](https://markdown.es/) que es muy fácil de interpretar (a poco que le dediquéis unos minutos) podemos modificar el archivo en cuestión, y a su lado aparecerá una **M** porqué el archivo está modificado.

<img src="assets/vscode_06_vscode2.png" alt="Screenshot_20220106_172048" style="zoom:50%;" />



## Git integrado

VSCode lleva integrado un gestor de GIT, el tercer icono de la barra lateral: ![Screenshot_20220106_172635](assets/vscode_07_git.png)

1. **Verificamos** los archivos cambiados:
<img src="assets/vscode_07_git1.png" alt="Verificar cambios" style="zoom: 80%;" />

2. Los pasamos a "**staged area**" con el símbolo "**+**":
<img src="assets/vscode_07_git2.png" alt="pasar a staged" style="zoom:80%;" />

4. Añadimos el **comentario** del commit:
<img src="assets/vscode_07_git3.png" alt="comentario commit" style="zoom:80%;" />

4. Realizamos el **commit**:
    <img src="assets/vscode_07_git4.png" alt="Screenshot_20220106_173720" style="zoom:80%;" />

> Si el repositorio no es nuestro mostrará este mensaje:
>
> ![Screenshot_20220106_173836](assets/vscode_07_git5.png)

En realidad podemos hacer el fork antes o después, aquí tienes un pequeño [vídeo](https://www.youtube.com/watch?v=zyT0sl3-kxE) que explica qué es un fork.

A continuación nos pide el nombre de la rama que se creará y que luego podremos solicitar se incluya en el proyecto original:

<img src="assets/vscode_07_git6.png" alt="branch" style="zoom:80%;" />

Ahora nos pregunta si ya que hemos creado un fork, queremos cambiar el repositorio, y trabajar sobre nuestro fork en lugar de sobre el proyecto original, pulsamos sobre [Switch to Fork]:

<img src="assets/vscode_07_git7.png" alt="cambiar al fork" style="zoom:80%;" />

Ahora ya podemos salir del editor VSCode pulsando sobre el botón de las tres lineas horizontales y elegir la opción "Go to Repository":

<img src="assets/vscode_07_git8.png" alt="Volver al repositorio" style="zoom:80%;" />



## Pull request

Una vez volvemos a nuestro repositorio (nuestro fork), detectará que hay cambios respecto al repositorio original y nos propone que realicemos un pull request (una petición al usuario propietario del repositorio original para que incluya nuestra modificación).

<img src="assets/vscode_08_pullrequest.png" alt="Screenshot_20220106_175237" style="zoom:80%;" />

Una vez pulsado el botón [Compare & pull request] nos aparece la siguiente pantalla:

![Screenshot_20220106_175639](assets/vscode_09_pullrequest2.png)

Debemos asegurarnos de que la modificación se puede agregar al repositorio original "*Able to merge*", y que indicamos en los comentarios nuestro nombre completo para que el *profesor* nos identifique. Fíjate que el nombre del pull request es el nombre del commit que hicimos desde VSCode.

Ahora debemos pulsar el botón [Create pull request].

# Tareas

##  GitHub 1

Sigue los pasos de esta práctica guiada para sugerir una modificación de cualquiera de los archivos de los repositorios del profesor [arturoblasco](https://github.com/arturoblasco). 

<ol>
    <li>Adjunta a la tarea de AULES un pdf de nombre actividad01tunombre con la captura de pantalla similar a esta donde se vé que has solicitado el pull request y que estás esperando a que se integre en el repositorio original. </li>
    <li>Explica qué significan cada uno de los 5 apartados señalados en la captura:</li></ol>

![Screenshot_20220106_180847](assets/vscode_10_pullrequest3.png)



## GitHub 2

Siguiendo los pasos de la práctica anterior,:

<ol><li>crearemos un repositorio en el que un compañero propondrá un pull-request que nosotros deberemos integrar en nuestro repositorio original y viceversa. </li>
    <li>deberemos realizar un pull-request a nuestro compañero y que él lo acepte.</li></ol>

Debes adjuntar a la tarea de AULES un pdf de nombre actividad02tunombre con los pasos a seguir una vez recibido el *pull-request* para aceptarlo y que se integre en nuestro repositorio, y mostrar además donde aparece el nombre del usuario que ha colaborado con nostros en el repositorio.



## Repositorio Local + VsCode + Repositorio remoto

En la siguiente práctica vamos a configurar el espació de trabajo en el que estaremos a lo largo de este curso/módulo de Programación.

La idea va a consistir en:

1. crear un proyecto Java en VS Code, 
2. en el que crearemos un repositorio local.
3. por otra parte, crearemos un repositorio remoto en GitHub (será privado y daremos acceso al profesor/a).
4. enlazaremos nuestro Git local con nuestro Git remoto (en GitHub); así, podremos ir subiendo todos nuestros programas.

Empecemos:

1. Abrimos VS Code. Accedemos a la pestaña de JAVA PROJECTS, pulsamos el icono de `+` y elegimos la primera opción `No build tools`.

   <img src="/assets/vscode_tarea3_01.png" style="zoom:80%;" />

   Se abre otra ventana flotante en la que elegimos el lugar donde va a ir nuestro proyecto; crearemos en nuestra raíz `~` la carpeta `pr` y pulsamos botón  `Select the project location`.

   <img src="/assets/vscode_tarea3_02.png" style="zoom: 67%;" />

   Escribimos el nombre del proyecto `exercicisJava`.

   <img src="/assets/vscode_tarea3_03.png" style="zoom:67%;" />

   > Podemos observar la estructura de nuestro primer proyecto Java.
   >
   > Observamos en primer lugar la carpeta `src` que será la que contenga todos nuestros ficheros fuente `.java`. A la derecha podemos observar el contenido del fichero App.java.
   >
   > La carpeta `bin` contendrá los ficheros ejecutables `.class` que se generen de la compilación de nuestros ficheros `.java`.
   >
   > <img src="/assets/vscode_tarea3_04.png" style="zoom:80%;" />

2. Des de un terminal, accedemos dentro de la carpeta de nuestro recién creado proyecto `~\pr\exercicisJava`. 

   ```sh
   cd ~\pr\exercicisJava
   ```

   <img src="/assets/vscode_tarea3_05a.png" style="zoom:67%;" />

   Inicializamos ahí dentro, con la orden `git init`, nuestro repositorio local Git.

   ```sh
   git init
   ```

   <img src="/assets/vscode_tarea3_05b.png" style="zoom:67%;" />

   Si vemos la estructura de la carpeta del proyecto vemos una carpeta oculta `.git`.

   <img src="/assets/vscode_tarea3_05c.png" style="zoom:67%;" />

   Si realizamos un `git status` observamos que todavía no hemos introducido las carpetas contenidas en el proyecto en nuestro repositorio. 

   ```sh
   git status
   ```

   <img src="/assets/vscode_tarea3_06.png" style="zoom:67%;" />

   Para ello: `git add .` y a continuación `git commit -m "1) cargar proyecto inicial"`.

   ```sh
   git add .
   ```

   ```sh
   git commit -m "1) carga proyecto inicial"
   ```

   <img src="/assets/vscode_tarea3_07.png" style="zoom:67%;" />

   Se puede comprobar con `git status` que, en este momento, no existe ninguna modificación en el área de trabajo que no se encuentre en el repositorio.

   <img src="/assets/vscode_tarea3_08.png" style="zoom:67%;" />

   Se puede observar este primer commit con `git log`.

   ```sh
   git log
   ```

   <img src="/assets/vscode_tarea3_09.png" style="zoom:67%;" />

   

3. Es hora de crear nuestro repositorio remoto en GitHub:

   <img src="/assets/vscode_tarea3_10.png" style="zoom:50%;" />

   El nombre de nuestro repositorio `exercicisJava`; descripción `1º CFGS DAW - Programación - Ejercicios de Java`, por ejemplo, acceso `Private` y NO crearemos el fichero README ni .gitignore (por ahora).

   <img src="/assets/vscode_tarea3_11.png" style="zoom:80%;" />

   ​		Si vemos el resultado de crear el anterior repositorio, entre otras opciones de terminar encontramos:	

   <img src="/assets/vscode_tarea3_12.png" style="zoom: 67%;" />

   ​		Vamos a terminar ejecutando esta orden en nuestro terminal (DENTRO de nuestra carpeta de proyecto Java / repositorio local Git):

   ```sh
   git remote add origin git@github.com:arturoblasco/exercicisJava.git
   ```

   ![](/assets/vscode_tarea3_13.png)

   ​	

   

4. Para terminar, enlazamos el repositorio local de Git con el repositorio remoto en GitHub:

   ```sh
   git push origin master
   ```

<img src="/assets/vscode_tarea3_14.png" style="zoom:67%;" />

​	Si vemos en nuestro repositorio de GitHub la sincronización ha sido realizada:

<img src="/assets/vscode_tarea3_15.png" style="zoom:67%;" />

​		Para terminar, ponemos al profesor/a del módulo de Programación como colaborador de nuestro repositorio:

<img src="/assets/vscode_tarea3_16.png" style="zoom:67%;" />

