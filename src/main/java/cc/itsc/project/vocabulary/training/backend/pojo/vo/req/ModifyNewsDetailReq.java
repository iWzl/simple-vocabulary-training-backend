package cc.itsc.project.vocabulary.training.backend.pojo.vo.req;

/**
 * @author Leonardo iWzl
 * @version 1.0
 */
public class ModifyNewsDetailReq {
    private int newsId;
    private String title;
    private String content;
    private String image;
    private int top;

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }
}
