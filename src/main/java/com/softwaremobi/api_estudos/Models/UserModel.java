package com.softwaremobi.api_estudos.Models;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Document(collection = "Users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel implements UserDetails {

    @Id
    private String id;
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @DBRef
    private ArrayList<FlashCardModel> flashCardModels = new ArrayList<>();
    @DBRef
    private ArrayList<TaskModel> taskModels  = new ArrayList<>();

    public void addFlashCard(FlashCardModel flashCardModel) {
        flashCardModels.add(flashCardModel);
    }
    public void addTask(TaskModel taskModel) {
        taskModels.add(taskModel);
    }
    public void removeFlashCard(FlashCardModel flashCardModel) {
        flashCardModels.remove(flashCardModel);
    }

    public void removeTask(TaskModel taskModel) {
        taskModels.remove(taskModel);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
