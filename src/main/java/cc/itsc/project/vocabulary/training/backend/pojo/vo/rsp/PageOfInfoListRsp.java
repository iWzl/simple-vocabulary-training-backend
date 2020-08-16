package cc.itsc.project.vocabulary.training.backend.pojo.vo.rsp;

import cc.itsc.project.vocabulary.training.backend.pojo.vo.HttpResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("分页用户信息列表")
public class PageOfInfoListRsp<T> implements HttpResponse {
    @ApiModelProperty(value = "当前页")
    private int pageNum;
    @ApiModelProperty("每页的数量")
    private int pageSize;
    @ApiModelProperty("当前页的数量")
    private int size;
    @ApiModelProperty("当前页面第一个元素在数据库中的行号")
    private int startRow;
    @ApiModelProperty("当前页面最后一个元素在数据库中的行号")
    private int endRow;
    @ApiModelProperty("总页数")
    private int pages;
    @ApiModelProperty("是否为第一页")
    private boolean isFirstPage;
    @ApiModelProperty("是否为最后一页")
    private boolean isLastPage;
    @ApiModelProperty("是否有前一页")
    private boolean hasPreviousPage;
    @ApiModelProperty("是否有后一页")
    private boolean hasNextPage;
    @ApiModelProperty("导航页码数")
    private int navigatePages;
    @ApiModelProperty("所有导航页号")
    private int[] navigatepageNums;
    @ApiModelProperty("所有导航页前一页")
    private int navigateFirstPage;
    @ApiModelProperty("所有导航页后一页")
    private int navigateLastPage;
    @ApiModelProperty("总数")
    private long total;

    @ApiModelProperty
    private List<T> dataList;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getStartRow() {
        return startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public int getEndRow() {
        return endRow;
    }

    public void setEndRow(int endRow) {
        this.endRow = endRow;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }


    public boolean getIsFirstPage() {
        return isFirstPage;
    }

    public void setIsFirstPage(boolean firstPage) {
        isFirstPage = firstPage;
    }

    public boolean getIsLastPage() {
        return isLastPage;
    }

    public void setIsLastPage(boolean lastPage) {
        isLastPage = lastPage;
    }

    public boolean getIsHasPreviousPage() {
        return hasPreviousPage;
    }

    public void setHasPreviousPage(boolean hasPreviousPage) {
        this.hasPreviousPage = hasPreviousPage;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public int getNavigatePages() {
        return navigatePages;
    }

    public void setNavigatePages(int navigatePages) {
        this.navigatePages = navigatePages;
    }

    public int[] getNavigatepageNums() {
        return navigatepageNums;
    }

    public void setNavigatepageNums(int[] navigatepageNums) {
        this.navigatepageNums = navigatepageNums;
    }

    public int getNavigateFirstPage() {
        return navigateFirstPage;
    }

    public void setNavigateFirstPage(int navigateFirstPage) {
        this.navigateFirstPage = navigateFirstPage;
    }

    public int getNavigateLastPage() {
        return navigateLastPage;
    }

    public void setNavigateLastPage(int navigateLastPage) {
        this.navigateLastPage = navigateLastPage;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
