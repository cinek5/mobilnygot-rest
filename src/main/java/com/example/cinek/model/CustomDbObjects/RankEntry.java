package com.example.cinek.model.CustomDbObjects;


public class RankEntry
{
    private Long id;
    private Integer position;
    private String name;
    private Integer points;

    public RankEntry(Long id, String name, Long points)
    {
        this.id = id;
        this.name = name;
        this.points = points.intValue();
    }

    public RankEntry(Long id, Integer position, String name, Long points)
    {
        this.id = id;
        this.position = position;
        this.name = name;
        this.points = points.intValue();
    }

    public RankEntry(Long id, String name, Integer points)
    {
        this.id = id;
        this.name = name;
        this.points = points;
    }

    public RankEntry() { }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getPoints()
    {
        return points;
    }

    public void setPoints(Integer points)
    {
        this.points = points;
    }
}
