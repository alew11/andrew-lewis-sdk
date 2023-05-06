package com.andrew.lewis.sdk.andrewlewissdk.lotr.quote.model;

import com.andrew.lewis.sdk.andrewlewissdk.lotr.movie.model.Movie;

import java.util.List;
import java.util.Objects;

public class LotrQuoteAPIResponseModel {
    private List<Quote> docs;
    private int total;
    private int limit;
    private int offset;
    private int page;
    private int pages;

    public LotrQuoteAPIResponseModel(List<Quote> docs, int total, int limit, int offset, int page, int pages) {
        this.docs = docs;
        this.total = total;
        this.limit = limit;
        this.offset = offset;
        this.page = page;
        this.pages = pages;
    }

    public LotrQuoteAPIResponseModel() {
    }

    public List<Quote> getDocs() {
        return docs;
    }

    public void setDocs(List<Quote> docs) {
        this.docs = docs;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LotrQuoteAPIResponseModel that = (LotrQuoteAPIResponseModel) o;
        return total == that.total && limit == that.limit && offset == that.offset && page == that.page && pages == that.pages && Objects.equals(docs, that.docs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(docs, total, limit, offset, page, pages);
    }
}
