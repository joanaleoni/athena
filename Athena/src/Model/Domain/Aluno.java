package Model.Domain;

import Model.DAO.AlunoDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;


public class Aluno extends Pessoa {
    private String curso;
    private int fase;
    private final AlunoDAO alunoDAO;

    public Aluno() {
        this.alunoDAO = new AlunoDAO();
    }   

    public Aluno(int fase, AlunoDAO alunoDAO) {
        this.fase = fase;
        this.alunoDAO = alunoDAO;
    }

    public Aluno(int fase, String curso) {
        this.curso = curso;
        this.fase = fase;
        this.alunoDAO = new AlunoDAO();
    }

    public Aluno(int fase, String curso, int matricula, String nome, LocalDate dataNascimento, String rg, String cpf) {
        super(matricula, nome, dataNascimento, rg, cpf);
        this.fase = fase;
        this.curso = curso;
        this.alunoDAO = new AlunoDAO();
    }
    
    public Aluno(int fase, String curso, String nome, LocalDate dataNascimento, String rg, String cpf) {
        super(nome, dataNascimento, rg, cpf);
        this.fase = fase;
        this.curso = curso;
        this.alunoDAO = new AlunoDAO();
    }

    public int getFase() {
        return fase;
    }

    public void setFase(int fase) {
        this.fase = fase;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Aluno{" + "fase=" + fase + ", curso=" + curso + ", dao=" + alunoDAO + '}';
    }

   
    public List<Aluno> getAlunos() {
        return alunoDAO.listar();
    }

    public boolean InsertAlunoBD(int fase, String curso, String nome, LocalDate dataNascimento, String rg, String cpf) throws SQLException {
        Aluno aluno = new Aluno(fase, curso, nome, dataNascimento, rg, cpf);
        alunoDAO.InsertAlunoBD(aluno);
        return true;

    }

    public boolean DeletetAlunoBD(int id) {
        alunoDAO.DeletetAlunoBD(id);
        return true;
    }

    public boolean UpdateAlunoBD(int fase, String curso, int matricula, String nome, LocalDate dataNascimento, String rg, String cpf) {
        Aluno objeto = new Aluno(fase, curso, matricula, nome, dataNascimento, rg, cpf);
        alunoDAO.UpdateAlunoBD(objeto);
        return true;
    }

    public Aluno carregaAluno(int matricula) {
        alunoDAO.carregaAluno(matricula);
        return null;
    }

}
