package Model.Domain;

import Model.DAO.ProfessorDAO;
import java.util.List;
import java.sql.SQLException;
import java.time.LocalDate;

public class Professor extends Pessoa {
    private LocalDate dataAdmissao;
    private String formacao;
    private String nivelTitulacao;
    
    private List<Disciplina> disciplinas;
    private final ProfessorDAO professorDAO; 


    public Professor(LocalDate dataAdmissao, String formacao, String nivelTitulacao, List<Disciplina> disciplinas) {
        this.dataAdmissao = dataAdmissao;
        this.formacao = formacao;
        this.nivelTitulacao = nivelTitulacao;
        this.professorDAO = new ProfessorDAO();
    }

    public Professor(LocalDate dataAdmissao, String formacao, String nivelTitulacao, int matricula, String nome, LocalDate dataNascimento, String rg, String cpf) {
        super(matricula, nome, dataNascimento, rg, cpf);
        this.dataAdmissao = dataAdmissao;
        this.formacao = formacao;
        this.nivelTitulacao = nivelTitulacao;
        this.professorDAO = new ProfessorDAO();
    }

    public Professor(LocalDate dataAdmissao, String formacao, String nivelTitulacao, String nome, LocalDate dataNascimento, String rg, String cpf) {
        super(nome, dataNascimento, rg, cpf);
        this.dataAdmissao = dataAdmissao;
        this.formacao = formacao;
        this.nivelTitulacao = nivelTitulacao;
        this.professorDAO = new ProfessorDAO();
    }
   
   
    public Professor() {
        this.professorDAO = new ProfessorDAO();
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public String getNivelTitulacao() {
        return nivelTitulacao;
    }

    public void setNivelTitulacao(String nivelTitulacao) {
        this.nivelTitulacao = nivelTitulacao;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
    
    public List<Professor> getProfessores(){
        return professorDAO.listar();
    }
    

    public boolean InsertProfessorBD(LocalDate dataAdmissao, String formacao, String nivelTitulacao, String nome, LocalDate dataNascimento, String rg, String cpf) throws SQLException {
        Professor objeto = new Professor(dataAdmissao, formacao, nivelTitulacao, nome, dataNascimento, rg, cpf);
        professorDAO.InsertProfessorBD(objeto);
        return true;
    }

    public boolean DeleteProfessorBD(int id) {
        professorDAO.DeleteProfessorBD(id);
        return true;
    }

    public boolean UpdateProfessorBD(LocalDate dataAdmissao, String formacao, String nivelTitulacao, int matricula, String nome, LocalDate dataNascimento, String rg, String cpf) {
        Professor objeto = new Professor(dataAdmissao, formacao, nivelTitulacao, matricula, nome, dataNascimento, rg, cpf);
        professorDAO.UpdateProfessorBD(objeto);
        return true;
    }

    public Professor carregaProfessor(int matricula) {
        professorDAO.carregaProfessor(matricula);
        return null;
    }
}
    

