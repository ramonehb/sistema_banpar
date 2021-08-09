package view;

import dao.CedenteDao;
import dao.UsuarioDao;
import model.Cedente;
import model.Usuario;

import java.sql.SQLOutput;
import java.util.*;

public class Main {
    /*
     * Adicionar update no usuário
     * Fazer telas Cedente e Operação
     */
    public static void main(String[] args) {
        UsuarioDao usuarioDao = new UsuarioDao();
        Scanner read = new Scanner(System.in);
        String usuario, senha;

        System.out.println("Banpar Fomento Comercial e Serviços");
        System.out.print("Entra com seus dados de acesso\n");
        System.out.print("Login: ");
        usuario = read.nextLine();
        System.out.print("Senha: ");
        senha = read.nextLine();

        if (usuarioDao.verificarAcesso(usuario, senha)) {
            int opc;
            int sair = 1;

            System.out.println("Bem vindo " + usuario);

            while (sair < 10) {
                System.out.print("\n1.Operações \n2.Acesso aos usuários \n3.Cedentes \n10.Sair do Sistema\nDigite a opção selecionada: ");
                int opcEntrada = read.nextInt();

                switch (opcEntrada) {
                    case 1 -> {
                        System.out.print("\n1.Consultar todas as operações n\2.Cadastrar operação \n3.Selecionar operação por ID" +
                                "\n4.Excluir Operação \n5.Selecionar operação por numero \n6.Atualizar Operação \n10.Sair do sistema \nDigite a opção selecionada: ");
                    }
                    case 2 -> {
                        System.out.print("\n1.Consultar todos usuários \n2.Cadastrar usuário \n3.Selecionar usuário por ID " +
                                "\n4.Excluir usuário \n5.Selecionar usuário por NOME \n6.Atualizar usuário \n10.Sair do sistema\nDigite a opção selecionada: ");
                        opc = read.nextInt();
                        String usuarioUs, senhaUs, emailUs, nascimentoUs;
                        int idUs, acessoUs;
                        switch (opc) {
                            case 1 -> {
                                System.out.println("Usuários Banpar");
                                System.out.println(usuarioDao.listar());
                            }
                            case 2 -> {
                                read.nextLine();
                                System.out.println("Cadastro de usuário");
                                System.out.print("\nLogin para seu usuário: ");
                                usuarioUs = read.nextLine();
                                System.out.print("\nSenha para seu usuário: ");
                                senhaUs = read.nextLine();
                                System.out.print("\nDigite seu e-mail: ");
                                emailUs = read.nextLine();
                                System.out.print("\nDigite a data de nascimento yyyy/mm/dd: ");
                                nascimentoUs = read.nextLine();
                                System.out.print("Nivel de acesso\n1.Administrador \n2.Usuário \nDigite a opção desejada: ");
                                acessoUs = read.nextInt();
                                //Verificar os dados antes do cadastro
                                usuarioDao.cadastrar(usuarioUs, senhaUs, emailUs, nascimentoUs, acessoUs);
                            }
                            case 3 -> {
                                System.out.println("--------------------------------USUÀRIOS CADASTRADOS---------------------------------------");
                                System.out.println(usuarioDao.listar());
                                System.out.print("Digite o ID que deseja buscar: ");
                                idUs = read.nextInt();
                                System.out.println(usuarioDao.select(idUs));
                            }
                            case 4 -> {
                                int alerta;

                                System.out.println("--------------------------------USUÀRIOS CADASTRADOS---------------------------------------");
                                System.out.println(usuarioDao.listar());

                                System.out.print("\nDigite o ID do usuário de deseja excluir: ");
                                idUs = read.nextInt();

                                System.out.print("\nALERTA TEM CERTEZA DA EXCLUSÃO DO USUÁRIO\n1.SIM \n2.NÃO \nDIGITE A OPÇÃO DESEJADA: ");
                                alerta = read.nextInt();
                                if (alerta == 1) {
                                    usuarioDao.delete(idUs);
                                } else {
                                    System.out.println(usuario + " NÂO EXCLUÍU NENHUM USUÀRIO\n");
                                }
                            }
                            case 5 -> {
                                String nome;
                                read.nextLine();
                                System.out.print("Pesquisar o nome: ");
                                nome = read.nextLine();
                                System.out.println(usuarioDao.selectNome(nome));
                            }
                            case 6 -> {
                                int confirmacao;
                                do {
                                    int id_selecionado;
                                    Usuario us = new Usuario();
                                    System.out.println(usuarioDao.listar());
                                    System.out.print("Selecione o ID que deseja alterar: ");
                                    id_selecionado = read.nextInt();
                                    //VALIDAR SE ID SELECIONADO EXISTE NO BANCO
                                    us = usuarioDao.select(id_selecionado);
                                    System.out.println("--------------------------------------------USUÁRIO SELECIONADO " + us.getUsuario().toUpperCase() + "-------------------------------");
                                    System.out.println(us);
                                    System.out.print("1.Confirmar usuário \n2.Escolher novamente \nDigite a opção selecionada: ");
                                    confirmacao = read.nextInt();
                                    read.nextLine();
                                    switch (confirmacao) {
                                        case 1 -> {
                                            System.out.print("Digite o novo nome do usuário: ");
                                            usuarioUs = read.nextLine();
                                            String senha_confirma;
                                            do {
                                                System.out.print("Digite a nova senha para o usuário: ");
                                                senhaUs = read.nextLine();
                                                System.out.print("Confirme a nova senha: ");
                                                senha_confirma = read.nextLine();
                                            } while (!Objects.equals(senhaUs, senha_confirma));
                                            System.out.print("Digite novo e-mail: ");
                                            emailUs = read.nextLine();
                                            acessoUs = 1;
                                            System.out.print("Digite a nova data de nascimento do usuário yyyy/mm/dd: ");
                                            nascimentoUs = read.nextLine();
                                            usuarioDao.atualizar(usuarioUs,senhaUs,emailUs,nascimentoUs,acessoUs,id_selecionado);
                                        }
                                        case 2 -> confirmacao = 2;
                                        default -> {
                                            System.out.println("Opção invalida digite novamente");
                                            confirmacao = 2;
                                        }
                                    }
                                } while (confirmacao == 2);
                                //FINALIZAR ATULIAZACAO DO USUARIO


                            }
                            case 10 -> {
                                sair = 10;
                                System.out.println("Volte sempre " + usuario + " :)");

                            }
                            default -> System.out.println("Opção invalida");
                        }
                    }
                    case 3 -> {
                        System.out.println("Cedentes");
                    }
                    case 10 -> {
                        sair = 10;
                        System.out.println("Volte sempre " + usuario + " :)");
                    }
                    default -> System.out.println("Opção Invalida");
                }
            }

        } else {
            System.out.println("Usuário ou Senha invalido");
        }
    }

    public static void msg(String msg) {
        System.out.println(msg);
    }
}
