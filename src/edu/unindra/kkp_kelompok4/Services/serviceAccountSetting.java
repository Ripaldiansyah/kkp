/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.unindra.kkp_kelompok4.Services;

import edu.unindra.kkp_kelompok4.model.modelAccountSetting;

/**
 *
 * @author ripal
 */
public interface serviceAccountSetting {
	void profileSetting(modelAccountSetting account);
	void displayAccount(modelAccountSetting account);
	void passwordChange(modelAccountSetting account);
	void pinChange(modelAccountSetting account);
}
