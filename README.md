# FiestaFlightGuard

Paper plugin source. Version in plugin metadata: 1.0.0. Requires Paper 1.21 or newer and Java 21.

The plugin removes creative-style flight while a player is in Survival, cancels survival flight toggles, and gives a player who is airborne slow falling before removing flight. Creative and Spectator flight are left alone. Elytra use is not changed.

Set PLUGIN_API_CLASSPATH to Paper's API libraries and run ./build.sh. The result is written to build/plugin.jar.

The plugin cannot stop another plugin or privileged server code from granting or forcing flight again. Test changes on a disposable server before deployment.
