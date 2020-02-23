# Baker portuguese recipes

[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=Baker%20portuguese%20recipes&color=informational)](https://github.com/jesperancinha/portuguese-recipes) 
[![GitHub release](https://img.shields.io/github/release-pre/jesperancinha/portuguese-recipes.svg)](#)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/4ba1ad293d674b00b66db2db6fc6e3e9)](https://www.codacy.com/manual/jofisaes/portuguese-recipes?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=jesperancinha/portuguese-recipes&amp;utm_campaign=Badge_Grade)
[![CircleCI](https://circleci.com/gh/jesperancinha/portuguese-recipes.svg?style=svg)](https://circleci.com/gh/jesperancinha/portuguese-recipes)
[![codebeat badge](https://codebeat.co/badges/58319e19-d5c1-414d-ad76-7f8acf833e60)](https://codebeat.co/projects/github-com-jesperancinha-portuguese-recipes-master)
[![Build Status](https://travis-ci.org/jesperancinha/portuguese-recipes.svg?branch=master)](https://travis-ci.org/jesperancinha/portuguese-recipes)
[![BCH compliance](https://bettercodehub.com/edge/badge/jesperancinha/portuguese-recipes?branch=master)](https://bettercodehub.com/results/jesperancinha/portuguese-recipes)
[![Build status](https://ci.appveyor.com/api/projects/status/k2ukf8h95eys6npr?svg=true)](https://ci.appveyor.com/project/jesperancinha/portuguese-recipes)
[![Known Vulnerabilities](https://snyk.io/test/github/jesperancinha/portuguese-recipes/badge.svg)](https://snyk.io/test/github/jesperancinha/portuguese-recipes)

[![GitHub language count](https://img.shields.io/github/languages/count/jesperancinha/portuguese-recipes.svg)](#)
[![GitHub top language](https://img.shields.io/github/languages/top/jesperancinha/portuguese-recipes.svg)](#)
[![GitHub top language](https://img.shields.io/github/languages/code-size/jesperancinha/portuguese-recipes.svg)](#)

## Introduction

Fellow colleagues at ING have developed the [Baker project](https://ing-bank.github.io/baker). In this project, we will examine its potential.

> Welcome to portuguese restaurant: "O Petisco de Olhão".
>
> Feel free to choose a menu
>
> ### peixinhos-da-horta-scala:
> -   Peixinhos da Horta baked in Scala [![alt text](Documentation/pr-Scala-s.png "Scala")](./peixinhos-da-horta-scala)
> 
> ### bacalhao-a-bras-java:
> -   Bacalhau à Brás baked in Java [![alt text](Documentation/pr-Java-s.png "Java")](./bacalhao-a-bras-java)
> 
> ### cataplana-de-ameijoas-clojure 
> -   Cataplana de ameijoas baked in Clojure [![alt text](Documentation/pr-Clojure-s.png "Clojure")](./cataplana-de-ameijoas-clojure)
>
> ### filhos-de-natal-kotlin 
> -   Filhós de Natal baked in Kotlin [![alt text](Documentation/pr-Kotlin-s.png "Kotlin")](./filhos-de-natal-kotlin)
>

In this setup, our restaurant is a specialist in making portuguese snacks and main courses. Let's check the menu!

[![alt text](Documentation/pr-Scala-s.png "Scala")](https://www.scala-lang.org/)
[![alt text](Documentation/pr-Java-s.png "Java")](https://docs.oracle.com/javase/tutorial/java/index.html)
[![alt text](Documentation/pr-Kotlin-s.png "Kotlin")](https://kotlinlang.org/)
[![alt text](Documentation/pr-Clojure-s.png "Clojure")](https://clojure.org/)

## Status

[Under construction...](https://github.com/jesperancinha/project-signer/blob/master/project-signer-templates/UnderConstruction.md)

## Hints & Tricks

-   Run Bash.EXE on windows
    -   Open PowerShell with Administrator rights
    -   Issue this command `Enable-WindowsOptionalFeature -Online -FeatureName Microsoft-Windows-Subsystem-Linux`
    -   Wait for completion
    -   Restart computer (Even if it says otherwise)
    -   Got to Windows store and install [Ubuntu](https://www.microsoft.com/en-us/p/ubuntu/9nblggh4msv6?activetab=pivot:overviewtab)
    -   Launch Ubuntu
    -   Wait for completion
    -   For Intellij, configure Terminal to run just bash.exe

-  Recipe for Java 8 on Windows Ubuntu Shell

```bash
apt -y install zip
add-apt-repository ppa:webupd8team/java
add-apt-repository ppa:linuxuprising/java
apt-get update
apt-get install oracle-java8-installer
apt install openjdk-8-jdk
```

-  Typical settings on a .bashrc file to get Gradle, GitPrompt, SDKMAN and some handy aliases.

```bash
export GRADLE_HOME=/opt/gradle/gradle-6.1.1
export PATH=${GRADLE_HOME}/bin:${PATH}
alias ll='ls -l -a --color=auto'
if [ -f "/root/.bash-git-prompt/gitprompt.sh" ]; then
    GIT_PROMPT_ONLY_IN_REPO=1
    source /root/.bash-git-prompt/gitprompt.sh
fi

alias java13="sdk use java 13.0.2.hs-adpt"
alias java12="sdk use java 12.0.2.hs-adpt"
alias java8="sdk use java 8.0.242.hs-adpt"
alias m2disable="rm ~/.m2/settings.xml"
alias m2enable="cp /your_repo_folder/settings.xml ~/.m2/"

#THIS MUST BE AT THE END OF THE FILE FOR SDKMAN TO WORK!!!
export SDKMAN_DIR="/root/.sdkman"
[[ -s "/root/.sdkman/bin/sdkman-init.sh" ]] && source "/root/.sdkman/bin/sdkman-init.sh"
```

-   Cool ZSH shell

```bash
apt -y install zsh
sh -c "$(curl -fsSL https://raw.githubusercontent.com/ohmyzsh/ohmyzsh/master/tools/install.sh)"
```

-   Lein

```bash
brew install leiningen
lein lein new app cataplana-de-ameijoas-clojure
```

## References

-   [ING Baker](https://github.com/ing-bank/baker)
-   [ING Baker Document](https://ing-bank.github.io/baker)
-   [Webgraphiz](http://www.webgraphviz.com/)
-   [scale.bythebay.io: Nikola Kasev, Declare, verify and execute microservices-based process flows](https://www.youtube.com/watch?v=0bWQwUmeXHU)
-   [MoSCoW](https://en.wikipedia.org/wiki/MoSCoW_method)
-   [Baker Runtime](https://search.maven.org/artifact/com.ing.baker/baker-runtime_2.12/3.0.1/jar)
-   [Ubuntu for Windows](https://www.microsoft.com/en-us/p/ubuntu/9nblggh4msv6?activetab=pivot:overviewtab)
-   [How to Install and Use the Linux Bash Shell on Windows 10](https://www.howtogeek.com/249966/how-to-install-and-use-the-linux-bash-shell-on-windows-10/)
-   [Oh My ZSH!](https://github.com/ohmyzsh/ohmyzsh/)
-   [10 easy ways to speed up Windows 10](https://www.cnet.com/how-to/easy-ways-to-speed-up-windows-10/)
-   [The Scala Profgramming Language](https://www.scala-lang.org/)
-   [Oracle Store](https://shop.oracle.com/)
-   [The Clojure Programming Language](https://clojure.org/)
-   [Kotlin Programming Language](https://kotlinlang.org/)
-   [Clojure for the Brave](https://www.braveclojure.com/getting-started/)

## Domain References

-   [Peixinhos da Horta by Vaqueiro](https://www.vaqueiro.pt/receitas/detalhe/1535/peixinhos-da-horta)
-   [BACALHAU À BRÁS (PORTUGUESE COD FISH À BRÁS)](https://easyportugueserecipes.com/bacalhau-a-bras-portuguese-cod-fish-a-bras/)

## About me

[![Twitter Follow](https://img.shields.io/twitter/follow/joaofse?label=João%20Esperancinha&style=social)](https://twitter.com/joaofse)
[![GitHub followers](https://img.shields.io/github/followers/jesperancinha.svg?label=jesperancinha&style=social)](https://github.com/jesperancinha)
[![Generic badge](https://img.shields.io/static/v1.svg?label=BitBucket&message=jesperancinha&color=navy)](https://bitbucket.org/jesperancinha)
[![Generic badge](https://img.shields.io/static/v1.svg?label=GitLab&message=jesperancinha&color=navy)](https://gitlab.com/jesperancinha)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Homepage&message=joaofilipesabinoesperancinha.nl&color=6495ED)](http://joaofilipesabinoesperancinha.nl)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Homepage&message=Time%20Disruption%20Studios&color=6495ED)](http://tds.joaofilipesabinoesperancinha.nl/)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Homepage&message=Image%20Train%20Filters&color=6495ED)](http://itf.joaofilipesabinoesperancinha.nl/)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Homepage&message=MancalaJE&color=6495ED)](http://mancalaje.joaofilipesabinoesperancinha.nl/)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Articles&message=On%20The%20Web&color=purple)](https://github.com/jesperancinha/project-signer/blob/master/project-signer-templates/LossArticles.md)
[![Generic badge](https://img.shields.io/static/v1.svg?label=DEV&message=Profile&color=green)](https://dev.to/jofisaes)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Medium&message=@jofisaes&color=green)](https://medium.com/@jofisaes)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Hackernoon&message=@jesperancinha&color=green)](https://hackernoon.com/@jesperancinha)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Free%20Code%20Camp&message=jofisaes&color=008000)](https://www.freecodecamp.org/jofisaes)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Hackerrank&message=jofisaes&color=008000)](https://www.hackerrank.com/jofisaes)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Code%20Forces&message=jesperancinha&color=008000)](https://codeforces.com/profile/jesperancinha)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Coder%20Byte&message=jesperancinha&color=008000)](https://coderbyte.com/profile/jesperancinha)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Code%20Wars&message=jesperancinha&color=008000)](https://www.codewars.com/users/jesperancinha)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Acclaim%20Badges&message=joao-esperancinha&color=red)](https://www.youracclaim.com/users/joao-esperancinha/badges)
[![Generic badge](https://img.shields.io/static/v1.svg?label=All%20Badges&message=Badges&color=red)](https://github.com/jesperancinha/project-signer/blob/master/project-signer-templates/Badges.md)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Status&message=Project%20Status&color=red)](https://github.com/jesperancinha/project-signer/blob/master/project-signer-templates/Status.md)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Google%20Apps&message=Joao+Filipe+Sabino+Esperancinha&color=orange)](https://play.google.com/store/apps/developer?id=Joao+Filipe+Sabino+Esperancinha)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Code%20Pen&message=jesperancinha&color=orange)](https://codepen.io/jesperancinha)
[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=ITF%20Chartizate%20Android&color=yellow)](https://github.com/JEsperancinhaOrg/itf-chartizate-android)
[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=ITF%20Chartizate%20Java&color=yellow)](https://github.com/JEsperancinhaOrg/itf-chartizate-modules/tree/master/itf-chartizate-java)
[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=ITF%20Chartizate%20API&color=yellow)](https://github.com/JEsperancinhaOrg/itf-chartizate/tree/master/itf-chartizate-api)
[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=Markdowner%20Core&color=yellow)](https://github.com/jesperancinha/markdowner/tree/master/markdowner-core)
[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=Markdowner%20Filter&color=yellow)](https://github.com/jesperancinha/markdowner/tree/master/markdowner-filter)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Docker%20Images&message=jesperanciha&color=099CEC)](https://github.com/jesperancinha/project-signer/blob/master/project-signer-templates/DockerImages.md)
