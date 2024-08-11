# <center>Gradle</center>
## Gradle的特点
1. #### 本质上.gradle脚本本质上是一个project对象，在脚本中一些带名字的配置项如buildscript、allProjects等本质上就是对象中的方法，而配置项后面的闭包{}就是参数，所以我们在使用这个配置项时本质上是在调用对象中的一个方法；
2. #### Project是Gradle中构建脚本的表示，一个构建脚本对应一个Project对象，Task是Gradle中最小的执行单元，表示一个独立的任务，Project为Task提供了执行的上下文。
## gradle的项目结构
首先在一个目录下面执行 `gradle init` 会生成以下结构，本质上就是调用init方法
1. **build.gradle**
   #### 它表示Gradle的项目构建脚本，在里面我们可以通过Groovy来编写脚本，在Gradle中，一个build.gradle就对应一个项目，build.gradle放在Gradle项目的根目录下，表示它对应的是根项目，build.gradle放在Gradle项目的其他子目录下，表示它对应的是子项目，Gradle构建时会为每一个build.gradle创建一个对应的Project对象，这样编写build.gradle时就可以使用Project接口中的方法。
2. **settings.gradle**
   #### 它表示Gradle的多项目配置脚本，存放在Gradle项目的根目录下，在里面可以通过include来决定哪些子项目会参与构建，Gradle构建时会为settings.gradle创建一个对应的Settings对象，include也只是Settings接口中的一个方法。
3. **Gradle Wrapper**
   #### `gradle init` 执行时会同时执行wrapper任务，wrapper任务会创建gradle/wrapper目录，并创建gradle/wrapper目录下的gradle-wrapper.jar、gradle-wrapper.properties这两个文件，还同时创建gradlew、gradlew.bat这两个脚本，它们统称为Gradle Wrapper，是对Gradle的一层包装。

   #### Gradle Wrapper的作用就是可以让你的电脑在不安装配置Gradle环境的前提下运行Gradle项目，例如当你的Gradle项目被用户A clone下来时，而用户A的电脑上没有安装配置Gradle环境，用户A通过Gradle构建项目时，Gradle Wrapper就会从指定下载位置下载Gradle，并解压到电脑的指定位置，然后用户A就可以在不配置Gradle系统变量的前提下在Gradle项目的命令行中运行gradlew或gradlew.bat脚本来使用gradle命令，假设用户A要运行gradle -v命令，在linux平台下只需要运行./gradlew -v，在window平台下只需要运行gradlew -v，只是把gradle替换成gradlew。

   #### gradle文件的含义
   1. gradlew：用于在linux平台下执行gradle命令的脚本；
   2. gradlew.bat：用于在window平台下执行gradle命令的脚本；
   3. gradle-wrapper.jar：包含Gradle Wrapper运行时的逻辑代码；
   4. gradle-wrapper.properties：用于指定Gradle的下载位置和解压位置；
   
   #### gradle-wrapper.properties 文件中的释义
   - distributionBase —— 下载的Gradle的压缩包解压后的主目录，为GRADLE_USER_HOME，在window中它表示C:/用户/你电脑登录的用户名/.gradle/，在mac中它表示～/.gradle/
   - distributionPath —— 相对于distributionBase的解压后的Gradle的路径，为wrapper/dists
   - distributionUrl —— Grade压缩包的下载地址
   - zipStoreBase —— 同distributionBase，不过是表示存放下载的Gradle的压缩包的主目录
   - zipStorePath —— 同distributionPath，不过是表示存放下载的Gradle的压缩包的路径
## gradle构建的生命周期
当在命令行输入gradle build构建整个项目或gradle task名称执行某个任务时就会进行Gradle的构建，它的构建过程分为3个阶段：
**init(初始化阶段) -> configure(配置阶段) -> execute(执行阶段)**

- init：初始化阶段主要是解析settings.gradle，生成Settings对象，确定哪些项目需要参与构建，为需要构建的项目创建Project对象；
- configure：配置阶段主要是解析build.gradle，配置init阶段生成的Project对象，构建根项目和所有子项目，同时生成和配置在build.gradle中定义的Task对象，构造Task的关系依赖图，关系依赖图是一个有向无环图；
- execute：根据configure阶段的关系依赖图执行Task.

## Task
### 让task支持增量式构建
首先我们要让Copy任务的inputs和outputs参与Gradle的Up-to-date检查，每一个Task都有inputs和outputs属性，它们的类型分别为TaskInputs和TaskOutputs，Task的inputs和outputs主要有以下三种类型：

- 可序列化类型：可序列化类型是指实现了Serializable的类或者一些基本类型如int、string等；
- 文件类型：文件类型是指标准的java.io.File或者Gradle衍生的文件类型如FileCollection、FileSystemLocation等；
- 自定义类型：自定义类型是指自己定义的类，这个类含有Task的部分输入和输出属性，或者说任务的部分输入和输出属性嵌套在这个类中.


