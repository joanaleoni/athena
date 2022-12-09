package Model.DAO;

import Model.Database.Database;
import Model.Database.DatabaseFactory;
import Model.Domain.Aluno;
import Model.Domain.Disciplina;
import Model.Domain.Professor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaDAO {
    private final Database database = DatabaseFactory.getDatabase("mysql");
    private final Connection connection = database.conectar();
    
    public Connection getConnection() {
        return connection;
    }

    public boolean inserir(Disciplina disciplina){
        String sql = "INSERT INTO disciplina(codigo, nome, cargaHoraria) VALUES(?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, disciplina.getCodigo());
            stmt.setString(2, disciplina.getNome());
            stmt.setInt(3, disciplina.getCargaHoraria());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
           throw new RuntimeException(ex);
        }
    }
    
    public boolean alterar(Disciplina disciplina){
        String sql = "UPDATE disciplina SET nome=?, cargaHoraria=? WHERE codigo=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, disciplina.getNome());
            stmt.setInt(2, disciplina.getCargaHoraria());
            stmt.setString(3, disciplina.getCodigo());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }       
    }
    
    public boolean remover(String codigo){
        String sql = "DELETE FROM disciplina WHERE codigo=?";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, codigo);
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public List<Disciplina> listar(){
        String sql = "SELECT codigo, disciplina.nome as nome_disciplina, cargaHoraria, matricula, professor.nome as nome_professor, " +
                     "dataNascimento, rg, cpf, dataAdmissao, salario, formacao, nivel_titulacao, ativo, turma.id as turma_id, ano_e_semestre FROM disciplina " +
                     "LEFT JOIN professor_ministra_disciplina ON professor_ministra_disciplina.disciplina_codigo=codigo " +
                     "LEFT JOIN professor ON professor_matricula=matricula " +
                     "LEFT JOIN disciplina_has_turma ON disciplina_has_turma.disciplina_codigo=codigo " +
                     "LEFT JOIN turma ON disciplina_has_turma.turma_id=turma.id";
        List<Disciplina> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Disciplina disciplina = new Disciplina();
                disciplina.setCodigo(resultado.getString("codigo"));
                disciplina.setNome(resultado.getString("nome_disciplina"));
                disciplina.setCargaHoraria(resultado.getInt("cargaHoraria"));
                disciplina.setProfessoresMinistrantes(listarProfessoresMinistrantes(disciplina));
        
                retorno.add(disciplina);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return retorno;
    }
    
    
    public List<Professor> listarProfessoresMinistrantes(Disciplina disciplina){
        String sql = "SELECT matricula, professor.nome as nome FROM professor " +
                     "LEFT JOIN professor_ministra_disciplina ON professor_matricula=matricula " +
                     "LEFT JOIN disciplina ON disciplina_codigo=?";
        List<Professor> retorno = new ArrayList<>();
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while(resultado.next()){
                Professor professor = new Professor();
                professor.setMatricula(resultado.getInt("matricula"));
                professor.setNome(resultado.getString("nome"));              
                retorno.add(professor);
     
            }
        } catch(SQLException ex){
            throw new RuntimeException(ex);
        }        
        return retorno;
    }   
    
    public Disciplina carregaDisciplina(String codigo){
        String sql = "SELECT * FROM disciplina WHERE codigo=?";
        Disciplina disciplina = new Disciplina();
        disciplina.setCodigo(codigo);
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, codigo);
            ResultSet resultado = stmt.executeQuery();
            
            if(resultado.next()){
                disciplina.setNome(resultado.getString("nome"));
                disciplina.setCargaHoraria(resultado.getInt("carga_horaria"));
            }           

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return disciplina;
    }
    
    public boolean adicionarProfessor(int matriculaProfessor, String codigoDisciplina){
        String sql = "INSERT INTO professor_ministra_disciplina VALUES(?,?)";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, matriculaProfessor);
            stmt.setString(2, codigoDisciplina);
            stmt.execute();
            stmt.close();            
            return true;
            
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        
    }
    
    public boolean excluirProfessor(int matriculaProfessor, String codigoDisciplina){
        String sql = "DELETE FROM professor_ministra_disciplina WHERE disciplina_codigo='?' AND professor_matricula=?";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, codigoDisciplina);
            stmt.setInt(2, matriculaProfessor);
            stmt.execute();
            stmt.close();
            return true;
            
        } catch (SQLException ex) {
           throw new RuntimeException(ex);
        }
        
    }
    
    public boolean matricularAluno(int matriculaAluno, String codigoDisciplina){
        String sql = "INSERT INTO disciplina_has_aluno VALUES(?,?)";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, codigoDisciplina);
            stmt.setInt(2, matriculaAluno);
            stmt.execute();
            stmt.close();
            return true;            
            
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public boolean desmatricularAluno(int matriculaAluno, String codigoDisciplina){
        String sql = "DELETE FROM disciplina_has_aluno WHERE disciplina_codigo='?' AND aluno_matricula=?";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, codigoDisciplina);
            stmt.setInt(2, matriculaAluno);
            stmt.execute();
            stmt.close();
            return true;
            
        } catch (SQLException ex) {
           throw new RuntimeException(ex);
        }
        
    }
}