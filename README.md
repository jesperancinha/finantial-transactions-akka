# Recipes Project

---

[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=Baker%20portuguese%20recipes&color=informational)](https://github.com/jesperancinha/portuguese-recipes) 
[![GitHub release](https://img.shields.io/github/release-pre/jesperancinha/portuguese-recipes.svg)](#)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/4ba1ad293d674b00b66db2db6fc6e3e9)](https://www.codacy.com/manual/jofisaes/portuguese-recipes?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=jesperancinha/portuguese-recipes&amp;utm_campaign=Badge_Grade)
[![CircleCI](https://circleci.com/gh/jesperancinha/portuguese-recipes.svg?style=svg)](https://circleci.com/gh/jesperancinha/portuguese-recipes)
[![codebeat badge](https://codebeat.co/badges/58319e19-d5c1-414d-ad76-7f8acf833e60)](https://codebeat.co/projects/github-com-jesperancinha-portuguese-recipes-master)
[![Build Status](https://travis-ci.com/jesperancinha/portuguese-recipes.svg?branch=master)](https://travis-ci.com/jesperancinha/portuguese-recipes)
[![BCH compliance](https://bettercodehub.com/edge/badge/jesperancinha/portuguese-recipes?branch=master)](https://bettercodehub.com/results/jesperancinha/portuguese-recipes)
[![Build status](https://ci.appveyor.com/api/projects/status/k2ukf8h95eys6npr?svg=true)](https://ci.appveyor.com/project/jesperancinha/portuguese-recipes)
[![Known Vulnerabilities](https://snyk.io/test/github/jesperancinha/portuguese-recipes/badge.svg)](https://snyk.io/test/github/jesperancinha/portuguese-recipes)

[![GitHub language count](https://img.shields.io/github/languages/count/jesperancinha/portuguese-recipes.svg)](#)
[![GitHub top language](https://img.shields.io/github/languages/top/jesperancinha/portuguese-recipes.svg)](#)
[![GitHub top language](https://img.shields.io/github/languages/code-size/jesperancinha/portuguese-recipes.svg)](#)

## Technologies used

---

[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/java-50.png "Java")](https://www.oracle.com/nl/java/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/lombok-50.png "Lombok")](https://projectlombok.org/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/kotlin-50.png "Kotlin")](https://kotlinlang.org/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/clojure-50.png "Clojure")](https://clojure.org/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/scala-50.png "Scala")](https://www.scala-lang.org/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/mockito-50.png "Mockito")](https://site.mockito.org/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/assertj-50.png "AssertJ")](https://assertj.github.io/doc/)

---

## Introduction
Fellow colleagues at [ING](https://www.ing.nl/) have developed the [Baker project](https://ing-bank.github.io/baker). In this project, we will examine its potential.

[Baker](https://ing-bank.github.io/baker) is a library which is responsible for the orchestration of different processes. Parallel to this, [Baker](https://ing-bank.github.io/baker/) creates [Graphviz](http://www.graphviz.org/) models and visualization flow charts which enable us to quickly visualize the status of our process.

| Project                                                          | Description                            | Language                                                                                -|
|------------------------------------------------------------------|----------------------------------------|------------------------------------------------------------------------------------------|
| [peixinhos-da-horta-scala](./peixinhos-da-horta-scala)           | Peixinhos da Horta baked in Scala      | [![alt text](Documentation/pr-Scala-s.png "Scala")](./peixinhos-da-horta-scala)          |
| [bacalhao-a-bras-java](./bacalhao-a-bras-java)                   | Bacalhau à Brás baked in Java          | [![alt text](Documentation/pr-Java-s.png "Java")](./bacalhao-a-bras-java)                |
| [cataplana-de-ameijoas-clojure](./cataplana-de-ameijoas-clojure) | Cataplana de ameijoas baked in Clojure | [![alt text](Documentation/pr-Clojure-s.png "Clojure")](./cataplana-de-ameijoas-clojure) |
| [filhos-de-natal-kotlin](./filhos-de-natal-kotlin)               | Filhós de Natal baked in Kotlin        | [![alt text](Documentation/pr-Kotlin-s.png "Kotlin")](./filhos-de-natal-kotlin)          |

This project is also the official support project of my article on medium:

[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/medium-20.png "Medium")](https://medium.com/swlh/baking-peixinhos-da-horta-with-ings-baker-library-528b39d2e8a7)
[Baking Peixinhos da Horta with ING’s Baker Library](https://medium.com/swlh/baking-peixinhos-da-horta-with-ings-baker-library-528b39d2e8a7)

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

-   Git tag change
```bash
git tag new-tag old-tag
git tag -d old-tag
git push origin :refs/tags/old-tag
git push --tags
git pull --prune --tags
```

## References

-   [ING Baker](https://github.com/ing-bank/baker)
-   [ING Baker Document](https://ing-bank.github.io/baker)
-   [Webgraphiz web App](http://www.webgraphviz.com/)
-   [Graphiz website](http://www.graphviz.org/)
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

## About me 👨🏽‍💻🚀🏳️‍🌈

[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/JEOrgLogo-20.png "João Esperancinha Homepage")](http://joaofilipesabinoesperancinha.nl)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/medium-20.png "Medium")](https://medium.com/@jofisaes)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/credly-20.png "Credly")](https://www.credly.com/users/joao-esperancinha)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Homepage&message=joaofilipesabinoesperancinha.nl&color=6495ED "João Esperancinha Homepage")](https://joaofilipesabinoesperancinha.nl/)
[![GitHub followers](https://img.shields.io/github/followers/jesperancinha.svg?label=jesperancinha&style=social "GitHub")](https://github.com/jesperancinha)
[![Twitter Follow](https://img.shields.io/twitter/follow/joaofse?label=João%20Esperancinha&style=social "Twitter")](https://twitter.com/joaofse)
[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=JEsperancinhaOrg&color=yellow "jesperancinha.org dependencies")](https://github.com/JEsperancinhaOrg)   
[![Generic badge](https://img.shields.io/static/v1.svg?label=Articles&message=Across%20The%20Web&color=purple)](https://github.com/jesperancinha/project-signer/blob/master/project-signer-templates/Articles.md)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Webapp&message=Image%20Train%20Filters&color=6495ED)](http://itf.joaofilipesabinoesperancinha.nl/)
[![Generic badge](https://img.shields.io/static/v1.svg?label=All%20Badges&message=Badges&color=red "All badges")](https://joaofilipesabinoesperancinha.nl/badges)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Status&message=Project%20Status&color=red "Project statuses")](https://github.com/jesperancinha/project-signer/blob/master/project-signer-quality/Build.md)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/coursera-20.png "Coursera")](https://www.coursera.org/user/da3ff90299fa9297e283ee8e65364ffb)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/google-apps-20.png "Google Apps")](https://play.google.com/store/apps/developer?id=Joao+Filipe+Sabino+Esperancinha)   
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/sonatype-20.png "Sonatype Search Repos")](https://search.maven.org/search?q=org.jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/docker-20.png "Docker Images")](https://hub.docker.com/u/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/stack-overflow-20.png)](https://stackoverflow.com/users/3702839/joao-esperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/reddit-20.png "Reddit")](https://www.reddit.com/user/jesperancinha/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/devto-20.png "Dev To")](https://dev.to/jofisaes)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/hackernoon-20.jpeg "Hackernoon")](https://hackernoon.com/@jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/codeproject-20.png "Code Project")](https://www.codeproject.com/Members/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/github-20.png "GitHub")](https://github.com/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/bitbucket-20.png "BitBucket")](https://bitbucket.org/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/gitlab-20.png "GitLab")](https://gitlab.com/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/bintray-20.png "BinTray")](https://bintray.com/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/free-code-camp-20.jpg "FreeCodeCamp")](https://www.freecodecamp.org/jofisaes)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/hackerrank-20.png "HackerRank")](https://www.hackerrank.com/jofisaes)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/codeforces-20.png "Code Forces")](https://codeforces.com/profile/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/codebyte-20.png "Codebyte")](https://coderbyte.com/profile/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/codewars-20.png "CodeWars")](https://www.codewars.com/users/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/codepen-20.png "Code Pen")](https://codepen.io/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/hacker-news-20.png "Hacker News")](https://news.ycombinator.com/user?id=jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/infoq-20.png "InfoQ")](https://www.infoq.com/profile/Joao-Esperancinha.2/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/linkedin-20.png "LinkedIn")](https://www.linkedin.com/in/joaoesperancinha/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/xing-20.png "Xing")](https://www.xing.com/profile/Joao_Esperancinha/cv)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/tumblr-20.png "Tumblr")](https://jofisaes.tumblr.com/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/pinterest-20.png "Pinterest")](https://nl.pinterest.com/jesperancinha/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/quora-20.png "Quora")](https://nl.quora.com/profile/Jo%C3%A3o-Esperancinha)

## Achievements

[![VMware Spring Professional 2021](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/badges/vmware-spring-professional-2021.png "VMware Spring Professional 2021")](https://www.credly.com/badges/762fa7a4-9cf4-417d-bd29-7e072d74cdb7)
[![Oracle Certified Professional, JEE 7 Developer](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/badges/oracle-certified-professional-java-ee-7-application-developer-100.png "Oracle Certified Professional, JEE7 Developer")](https://www.credly.com/badges/27a14e06-f591-4105-91ca-8c3215ef39a2)
[![Oracle Certified Professional, Java SE 11 Programmer](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/badges/oracle-certified-professional-java-se-11-developer-100.png "Oracle Certified Professional, Java SE 11 Programmer")](https://www.credly.com/badges/87609d8e-27c5-45c9-9e42-60a5e9283280)
[![Oracle Certified Professional, Java SE 8 Programmer](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/badges/oracle-certified-professional-java-se-8-programmer-100.png "Oracle Certified Professional, Java SE 8 Programmer")](https://www.credly.com/badges/92e036f5-4e11-4cff-9935-3e62266d2074)
[![Oracle Certified Associate, Java SE 8 Programmer](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/badges/oracle-certified-associate-java-se-8-programmer-100.png "Oracle Certified Associate, Java SE 8 Programmer")](https://www.credly.com/badges/a206436d-6fd8-4ca1-8feb-38a838446ee7)
[![Oracle Certified Associate, Java SE 7 Programmer](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/badges/oracle-certified-associate-java-se-7-programmer-100.png "Oracle Certified Associate, Java SE 7 Programmer")](https://www.credly.com/badges/f4c6cc1e-cb52-432b-904d-36d266112225)
[![Oracle Certified Junior Associate](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/badges/oracle-certified-foundations-associate-java-100.png "Oracle Certified Foundations Associate")](https://www.credly.com/badges/6db92c1e-7bca-4856-9543-0d5ed0182794)
