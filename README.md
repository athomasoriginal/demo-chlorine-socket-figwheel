# chlorine-socket-figwheel

This is meant to be a minimal example of how to connect a figwheel REPL to Chlorine.  Thus, we are showing you:

- how to run figwheel in a socket repl
- how to connect the figwheel socket repl to Chlorine

The files that matter:

- `dev/user.clj`

## Housekeeping

- java installed
- clj installed
- chlorine installed in atom editor

## Quick Start

- Run a clojure repl
  ```bash
  clj
  ```
- Start the CLJS repl
  ```bash
  (run-cljs-repl)
  ```
  > type the above into the repl opened when you ran `clj` in the first step
- Open you atom editor
- Open the command pallette
  ```bash
  command + shift + p
  ```
  > The above is on macos
- type `connect`
  You should see "chlorine: connect socket repl"
- Enter the port number
  ```bash
  9002
  ```

Wait a moment and chlorine should connect and you will know because a blue alert box will appear in the Atom editor.  From here, open `chlorine_socket_figwheel.cljs` and try to run some commands.
