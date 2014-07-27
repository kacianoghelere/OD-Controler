package br.com.odcontroler.data.db;

import br.com.odcontroler.data.db.interfaces.DAO;
import br.com.gmp.utils.object.ObjectCopy;
import br.com.gmp.utils.system.SystemProperties;
import br.com.odcontroler.data.db.map.EntityMap;
import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import java.io.File;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO Genérico para embasamento
 *
 * @author kaciano
 * @version 1.0
 * @param <T> Classe de entidade
 */
public class GenericDAO<T> implements DAO<T> {

    private Class<T> objectClass;
    private String dir = ".config/rpg/";
    private String database;
    private String sufix = ".yap";

    /**
     * Cria nova instancia de GenericDAO
     */
    public GenericDAO() {
        this.objectClass = (Class<T>) ((ParameterizedType) (getClass()
                .getGenericSuperclass())).getActualTypeArguments()[0];
        File file = new File(dir);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.database = dir + (new EntityMap().getMap().get(objectClass)) + sufix;
    }

    /**
     * Retorna a conexão com o banco de dados para buscas externas
     *
     * @return {@code ObjectContainer} Conexão com o banco
     */
    @Override
    public ObjectContainer getClient() {
        return Db4o.openFile(database);
    }

    /**
     * Busca todos os dados da entidade
     *
     * @return {@code T} Entidade
     */
    @Override
    public List<T> getList() {
        ObjectContainer db = getClient();
        Query query = db.query();
        query = new QueryBuilder(query)
                .constrain(objectClass)
                .descend("id")
                .orderAscending()
                .ready();
        ObjectSet os = query.execute();
        List<T> objs = new ArrayList<>();
        objs.addAll(os);
        db.close();
        return objs;
    }

    /**
     * Insere a entidade no banco de dados
     *
     * @param entity {@code T} Entidade
     */
    @Override
    public void insert(T entity) {
        ObjectContainer db = getClient();
        db.store(entity);
        db.commit();
        db.close();
    }

    /**
     * Insere as entidades no banco de dados
     *
     * @param entities {@code List(T)} Entidades
     */
    @Override
    public void insertAll(List<T> entities) {
        ObjectContainer db = getClient();
        for (T entity : entities) {
            db.store(entity);
        }
        db.commit();
        db.close();
    }

    /**
     * Atualiza a entidade
     *
     * @param entity {@code T} Entidade
     * @throws java.lang.IllegalAccessException Acesso ilegal
     */
    @Override
    public void update(T entity) throws IllegalArgumentException, IllegalAccessException {
        ObjectContainer db = getClient();
        ObjectSet<T> get = db.queryByExample(entity);
        ObjectCopy.copy(entity, get);
        db.store(get);
        db.commit();
        db.close();
    }

    /**
     * Deleta todos os objetos da lista
     *
     * @param entities {@code List(T)} Lista a ser deletada
     */
    @Override
    public void deleteAll(List<T> entities) {
        ObjectContainer db = getClient();
        for (T entity : entities) {
            ObjectSet<T> os = db.queryByExample(entity);
            db.delete(os.next());
        }
        db.commit();
        db.close();
    }

    /**
     * Deleta todos os objetos do banco
     */
    @Override
    public void deleteAll() {
        ObjectContainer db = getClient();
        ObjectSet<T> query = db.query(objectClass);
        for (T t : query) {
            db.delete(t);
        }
        db.commit();
        db.close();
    }

    /**
     * Deleta a entidade
     *
     * @param entity {@code T} Entidade
     */
    @Override
    public void delete(T entity) {
        ObjectContainer db = getClient();
        ObjectSet<T> os = db.queryByExample(entity);
        db.delete(os.next());
        db.commit();
        db.close();
    }

    /**
     * Deleta todos os registros anteriores e insere os registros da lista
     *
     * @param entities {@code List(T)} Lista dos novos registros
     */
    @Override
    public void replaceAll(List<T> entities) {
        deleteAll();
        insertAll(entities);
    }

    /**
     * Retorna a entidade a partir do ID
     *
     * @param id {@code Integer} ID
     * @return {@code T} Entidade
     */
    @Override
    public T queryByID(int id) {
        ObjectContainer db = getClient();
        Query query = db.query();
        query = new QueryBuilder(query)
                .constrain(objectClass)
                .searchFor("id", id)
                .descend("id")
                .orderAscending()
                .ready();
        ObjectSet<T> os = query.execute();
        List<T> list = new ArrayList<>();
        list.addAll(os);
        db.close();
        for (T entity : list) {
            return entity;
        }
        return null;
    }

    /**
     * Efetua a busca com base no campo informado
     *
     * @param field {@code String} Campo a ser verificado
     * @param value {@code Object} Valor da busca
     * @return {@code List(T)} Lista contendo o resultado
     */
    @Override
    public List<T> queryByField(String field, Object value) {
        List<T> list = new ArrayList<>();
        ObjectContainer db = getClient();
        Query query = db.query();
        query = new QueryBuilder(query)
                .constrain(objectClass)
                .searchFor(field, value)
                .descend("id")
                .orderAscending()
                .ready();
        ObjectSet<T> os = query.execute();
        list.addAll(os);
        db.close();
        return list;
    }

    /**
     * Retorna a classe do objeto que aplica o DAO
     *
     * @return {@code Class(?)} Classe do DAO
     */
    @Override
    public Class<T> getObjClass() {
        return objectClass;
    }

    /**
     * Modifica a classe do objeto que aplica o DAO
     *
     * @param oClass {@code Class(?)} Classe do DAO
     */
    @Override
    public void setObjClass(Class<T> oClass) {
        this.objectClass = oClass;
    }

    /**
     * Retorna o prefixo da base de dados (Caminho do arquivo)
     *
     * @return {@code String} Prefixo da base de dados
     */
    @Override
    public String getDir() {
        return dir;
    }

    /**
     * Modifica o prefixo da base de dados (Caminho do arquivo)
     *
     * @param dir {@code String} Prefixo da base de dados
     */
    public void setDir(String dir) {
        this.dir = dir;
    }

    /**
     * Retorna o nome da base de dados
     *
     * @return {@code String} Nome da base de dados
     */
    @Override
    public String getDatabase() {
        return database;
    }

    /**
     * Modifica o nome da base de dados
     *
     * @param database {@code String} Nome da base de dados
     */
    @Override
    public void setDatabase(String database) {
        this.database = database;
    }

    /**
     * Retorna o sufixo da base de dados (Extensão do arquivo)
     *
     * @return {@code String} sufixo da base de dados (Extensão do arquivo)
     */
    @Override
    public String getSufix() {
        return sufix;
    }

    /**
     * Modifica o sufixo da base de dados (Extensão do arquivo)
     *
     * @param sufix {@code String} Sufixo da base de dados (Extensão do arquivo)
     */
    public void setSufix(String sufix) {
        this.sufix = sufix;
    }
}
