# cake-maker

## Introduction

Fellow colleagues at ING have developed the Baker project. In this project, we will examine its potential

> Story line coming up

## Status

[Under construction...](https://github.com/jesperancinha/project-signer/blob/master/project-signer-templates/UnderConstruction.md)

## Hints & Tricks

-   Run Bash.EXE on windows
    -   Open PowerShell with Administrator rights
    -   Issue this command `Enable-WindowsOptionalFeature -Online -FeatureName Microsoft-Windows-Subsystem-Linux`
    -   Wait for completion
    -   Restart computer (Even if it says otherwise)
    -   Got to Windows store and install Ubuntu
    -   Launch Ubuntu
    -   Wait for completion

-  Recipe for Java 8 on Windows Ubuntu Shell

```bash
apt -y install zip
add-apt-repository ppa:webupd8team/java
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

## References

-   [ING BAKER](https://github.com/ing-bank/baker)
-   [scale.bythebay.io: Nikola Kasev, Declare, verify and execute microservices-based process flows](https://www.youtube.com/watch?v=0bWQwUmeXHU)
-   [MoSCoW](https://en.wikipedia.org/wiki/MoSCoW_method)
-   [Baker Runtime](https://search.maven.org/artifact/com.ing.baker/baker-runtime_2.12/3.0.1/jar)
-   [Ubuntu for Windows](https://www.microsoft.com/en-us/p/ubuntu/9nblggh4msv6?activetab=pivot:overviewtab)
-   [How to Install and Use the Linux Bash Shell on Windows 10](https://www.howtogeek.com/249966/how-to-install-and-use-the-linux-bash-shell-on-windows-10/)
-   [Oh My ZSH!](https://github.com/ohmyzsh/ohmyzsh/)