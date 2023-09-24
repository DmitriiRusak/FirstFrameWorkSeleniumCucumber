Originally one big file of stepDefinitions has been splited into a multiple. It is become
available because we use Dependency injections (with pico container) so now we are able
to use for example Webdriver variable in any class definition.

Now it is relativly easy to maintain the code. Each class is focus on a specific
task. We follow the single responsebility principle. If something changese, for example in the cart
page we know where exactly we need to look for updates -> CartDefinition and so on.