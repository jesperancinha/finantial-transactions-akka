FROM jesperancinha/je-all-build-jdk-8:0.0.1

ENV runningFolder /usr/local/bin/

WORKDIR ${runningFolder}

COPY bacalhao-a-bras-java $runningFolder/bacalhao-a-bras-java

COPY cataplana-de-ameijoas-clojure $runningFolder/cataplana-de-ameijoas-clojure

COPY filhos-de-natal-kotlin $runningFolder/filhos-de-natal-kotlin

COPY peixinhos-da-horta-scala $runningFolder/peixinhos-da-horta-scala

COPY entrypoint.sh $runningFolder

ENTRYPOINT $runningFolder/entrypoint.sh