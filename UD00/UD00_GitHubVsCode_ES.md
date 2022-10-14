---
<<<<<<< HEAD
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
=======
    unit: UD00
    title: Cómo usar el VSCode integrado en GitHub
    language: ES
    author: Arturo BC [arturoblasco@iesmre.com]
    subject: Programación
    keywords: [PROG, 2022, Programación]
    IES: IES Mestre Ramón Esteve (Catadau) [iesmre.es]
    header: ${unit}: ${title} - ${subject} (${today})
    footer:${currentFileName}.pdf - ${author} - ${IES} - ${pageNo}/${pageCount}
    typora-root-url:${filename}/../
    typora-copy-images-to:${filename}/../assets
    imgcover:./assets/cover.png
>>>>>>> 976ff0d06f7040cf494ba7ea57a7172ca0091835
---
[toc]
# `VsCode` integrado en `GitHub`

## Localizar repositorio.

Primero localizamos el repositorio con el que queremos colaborar:

1. Buscamos al usuario (En todo `GitHub`):

<img src="assets/vscode_01_localizar_repositorio.png" alt="Localizar repositorio" style="zoom:50%;" />

2. Elegimos la pestaña `Repositorios` y después el repositorio en cuestión:

<img src="assets/vscode_02_localizar_repositorio.png" alt="Localizar repositorio 2" style="zoom:50%;" />



## Abrir `VSCode` integrado.

Github cuenta con un editor online muy potente basado en `VSCode`.

Una vez visualizamos el código del repositorio en cuestión:

<img src="assets/vscode_03_codigo.png" alt="Screenshot_20220106_171327" alt="Código" style="zoom:50%;" />

para abrir el editor solo debemos pulsar la tecla "." (punto) de nuestro teclado:

<img src="assets/vscode_05_vscode1.png" alt="editor VSCode" style="zoom:50%;" />

Visualizaremos la estructura de carpetas y archivos en un editor `VSCode` integrado en el navegador Web.



## Modificar un archivo.

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