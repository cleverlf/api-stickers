package com.imersaojava;

public enum TERMINALFORMAT {
    RESET("\u001B[0m"),
    // cor do texto
    BRIGHT_GREEN("\u001b[92m"),
    BRIGHT_AZUL("\u001b[96m"),
    BRIGHT_YELLOW("\u001b[93m"),
    // emoji estrela
    STAR("\u2b50");

    private String s;

    private TERMINALFORMAT(String s) {
        this.s = s;
    }

    public String getS() {
        return s;
    }

}
