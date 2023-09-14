package org.adalocatecar.ui;

public class UIMenu {
    private UIMenu(){}

    public static void printMenu() {
        System.out.println("========== MENU ========== \n");
        System.out.println("Escolha uma opção:");

        System.out.println("1. Cadastrar veículo");
        System.out.println("2. Alterar veículo");
        System.out.println("3. Buscar veículo por parte do nome");
        System.out.println("4. Cadastrar cliente");
        System.out.println("5. Alterar cliente");
        System.out.println("6. Alugar veículo");
        System.out.println("7. Devolver veículo");
        System.out.println("8. Sair");

        System.out.println("\n");
    }
}
