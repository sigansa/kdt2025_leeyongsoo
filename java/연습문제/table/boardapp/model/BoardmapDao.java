package boardapp.model;


import java.util.List;

public interface BoardmapDao {
    public int insert(BoardmapDto params);
    public int delete(int params);
    public int update(BoardmapDto params);
    public BoardmapDto selectOne(int params);
    public List<BoardmapDto> select();
}
