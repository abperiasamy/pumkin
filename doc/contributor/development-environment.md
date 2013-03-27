# How to setup a Pumkin Development environment ?
This documentation provides details about how to get a development
environment ready for hacking Pumkin source code.

## Pumkin Git Repository
Fork Pumkin/pumkin repository with the github.com UI. Then clone your
repository to your laptop. Upstream is pumkin's official
repository. Origin is your forked copy at you@github.com. In addition
you have a working clone on your laptop. Treat origin as your laptop
backup.

Setup your own repository:
```
   * Login to github.com and fork from upstream to create origin.
   * Clone your origin.
   $ git clone git@github.com:YOURNAME/pumkin.git
   $ git pull
```

Receive updates from the upstream:
```
   $ git remote add upstream git@github.com:Pumkin/pumkin.git
   $ git fetch upstream
   $ git merge upstream
```

Send enhancements to upstream:
```
   $ git push origin
   * Login to github.com and generate a pull-request.
```
## Leiningen Basic Docs
* https://github.com/technomancy/leiningen/blob/stable/doc/TUTORIAL.md
* http://alexott.net/en/clojure/ClojureLein.html

## Install Lein
* Download the lein script from https://raw.github.com/technomancy/leiningen/stable/bin/lein
* Place it on your $PATH (eg. ~/bin)
* Set it to be executable. (chmod a+x ~/bin/lein)
* lein is basically a wrapper/bootstrap shell script. When ever you execute
  it, it downloads necessary jar dependencies automatically.

## Install Clojure
* Do not install clojure distributed via apt or yum repositories. Lein does that
  automatically.
* If you run "lein repl", it will download clojure and dependent jar files to
  ~/.lein and throw a clojure REPL prompt.
```
  $ lein repl
  => (clojure-version)
```
* If you run "lein repl", from within the pumkin source repository, you will
  get a clojure REPL specific to pumkin'sminimum requirements.
```
  $ cd git/pumkin
  $ lein repl
  => (clojure-version)
```
