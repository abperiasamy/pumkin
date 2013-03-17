# GNU Emacs configuration

This documentation provides two types of development configuration for Emacs.

* Prelude based config
* Manual config

## Prelude config

Emacs Prelude is compatible ONLY with GNU Emacs 24.x.

Assuming you're using an Unix-like OS (*BSD, GNU/Linux, OS X, Solaris, etc), you
already have Emacs 24 installed, as well as git & curl you can skip the whole
manual and just type in your favorite shell the following command:

```
$ curl -L https://github.com/bbatsov/prelude/raw/master/utils/installer.sh | sh
```
You can now power up your Emacs, sit back and enjoy Prelude, forgetting about
the rest of this manual.

## Manual config

Note: ~/.emacs startup is deprecated. Use ~/.emacs.d/init.el instead.
       $ mv ~/.emacs ~/.emacs.d/init.el

### GNU Emacs Package Management
GNU Emacs comes with its own 'apt' like package manager. If you have not
configured it yet, add these lines to your ~/.emacs.d/init.el and restart
emacs.

```
  ;;;; Emacs package management
  (require 'package)
  (setq package-archives '(("gnu" . "http://elpa.gnu.org/packages/")
                           ("marmalade" . "http://marmalade-repo.org/packages/")
                           ("melpa" . "http://melpa.milkbox.net/packages/")))
  (package-initialize)
```

Download new package listing:
 M-x package-refresh-contents

Package management interface:
 M-x package-list-packages

Note: Also check to see if you have older package.el related configuration in
      your init.el. It may conflict with this new configuration. It may be ok
      to delete them.

You can use keys like 'i' to mark for installation, 'd' to mark for
deletion and 'x' to execute changes.

### Highlight matching parenthesis
```
  ;;;; Highlight matching parenthesis
  (show-paren-mode)
```

### Colorful parenthesis
Color match matching parenthesis.
```
  ;;;; Rainbow delimiters
  ;; M-x package-install-> rainbow-delimiters
  (global-rainbow-delimiters-mode)
```

### Personalized emacs theme
Emacs comes with a bunch of themes for both console and GUI. Pick your own
favorite theme from the list.
```
  ;;;; Dark soothing wombot theme
  ;; M-x package-install -> color-theme-wombat
  (load-theme 'wombat t)
```

### Paredit Mode
Auto-complete parenthesis, quotes ..
```
  ;;;; Auto-complete parenthesis, quotes ..
  ;; M-x package-install-> paredit
  (add-hook 'clojure-mode-hook 'paredit-mode)
  (add-hook 'nrepl-mode-hook 'paredit-mode)
  (global-set-key [f7] 'paredit-mode)
```

### Clojure repl inside emacs
Install the following packages to integrate emacs with lein's repl and add
auto-completion capabilities.

* nrepl package to connect to lien's REPL server:
 M-x package-install -> nrepl

* Auto-completion framework:
 M-x package-install -> auto-complete

* Auto-complete integration for nrepl:
 M-x package-install -> ac-nrepl

```
  ;;;; nrepl integration
  (add-hook 'nrepl-interaction-mode-hook 'nrepl-turn-on-eldoc-mode)
  (setq nrepl-popup-stacktraces nil)
  (add-to-list 'same-window-buffer-names "*nrepl*")
  (add-hook 'nrepl-mode-hook 'paredit-mode)

  ;; nrepl-jack-in command is used to start interactive REPL session.
  ;; One might prefer to bind it to some key:
  (global-set-key [f9] 'nrepl-jack-in)

  ;; Auto completeion
  (require 'auto-complete-config)
  (ac-config-default)
  (define-key ac-completing-map "\M-/" 'ac-stop) ; use M-/ to stop completion

  ;; Integrate nrepl and auto-completion
  (require 'ac-nrepl)
  (add-hook 'nrepl-mode-hook 'ac-nrepl-setup)
  (add-hook 'nrepl-interaction-mode-hook 'ac-nrepl-setup)
  (eval-after-load "auto-complete" '(add-to-list 'ac-modes 'nrepl-mode))
```

To start Clojure REPL inside Emacs

 M-x nrepl-jack-in

Note: If you launch emacs from within pumkin directory, and type M-x
      nrepl-jack-in, it will start repl with dependencies as dictated by
      "project.clj".
```
      $ cd git/pumkin
      $ emacs
        M-x nrepl-jack-in
```
Note: It make take some time if you are running for the first time. Lein will
      download dependencies.
