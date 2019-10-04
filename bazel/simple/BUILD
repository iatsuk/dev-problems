java_library(
    name = "helloworld-lib",
    srcs = glob(["src/main/java/net/iatsuk/bazel/simple/HelloWorld.java"]),
)

java_binary(
    name = "helloworld",
    main_class = "net.iatsuk.bazel.simple.HelloWorld",
    runtime_deps = [":helloworld-lib"],
)

