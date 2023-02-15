package com.api.dto;

import com.api.model.UsuarioModel;
import java.util.Date;

/**
 *
 * @author Miguel Castro
 */
public class UsuarioResponseDto {

    private Long id;
    private String login;
    private String avatar_url;
    private String name;
    private String company;
    private String blog;
    private String location;
    private String email;
    private String bio;
    private Integer followers;
    private Integer following;
    private Date created_at;
    private Date updated_at;

    public UsuarioResponseDto(Long id, String login, String avatar_url, String name, String company, String blog, String location, String email, String bio, Integer followers, Integer following, Date created_at, Date updated_at) {
        this.id = id;
        this.login = login;
        this.avatar_url = avatar_url;
        this.name = name;
        this.company = company;
        this.blog = blog;
        this.location = location;
        this.email = email;
        this.bio = bio;
        this.followers = followers;
        this.following = following;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    //Método para converter entidade em DTO.
    public static UsuarioResponseDto converterEntidadeParaUsuarioDto(UsuarioModel usuarioModel) {
        return new UsuarioResponseDto(usuarioModel.getId(), usuarioModel.getLogin(), usuarioModel.getAvatar_url(),
                usuarioModel.getName(), usuarioModel.getCompany(), usuarioModel.getBlog(), usuarioModel.getLocation(),
                usuarioModel.getEmail(), usuarioModel.getBio(), usuarioModel.getFollowers(), usuarioModel.getFollowing(),
                usuarioModel.getCreated_at(), usuarioModel.getUpdated_at());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Integer getFollowers() {
        return followers;
    }

    public void setFollowers(Integer followers) {
        this.followers = followers;
    }

    public Integer getFollowing() {
        return following;
    }

    public void setFollowing(Integer following) {
        this.following = following;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }
}
