package pom;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.util.Objects;

import static com.codeborne.selenide.Condition.visible;

public class ProfilePage {

    @FindBy(xpath = "//div[contains(text(), 'Full name')]/following-sibling::div")
    public SelenideElement fullNameInAdditionalInfo;
    @FindBy(css = "div.mdc-card h2")
    public SelenideElement fullNameInAvatarSection;
    @FindBy(css = "div.mdc-card div.mdc-card__action-icons button[title='More options']")
    public SelenideElement editIconInAvatarSection;
    @FindBy(xpath = "//form[@id='update-item']//span[contains(text(),'New Avatar')]/following-sibling::input")
    public SelenideElement newAvatarFieldOnEditingPopup;
    @FindBy(xpath = "//form[@id='update-item']//span[contains(text(), 'Birthdate')]/following-sibling::input")
    public SelenideElement birthDateFieldOnEditingPopup;
    @FindBy(css = "form#update-item button")
    public SelenideElement saveButtonOnEditingPopup;
    @FindBy(xpath= "//h2[@id='profileForm-title']/../button")
    private SelenideElement closeButtonOnEditingPopup;
    @FindBy(xpath = "//h3/following-sibling::div" +
            "//div[contains(text(), 'Date of birth')]/following-sibling::div")
    private SelenideElement birthDateOnProfilePage;

    public void clickEditIconInAvatarSection() {
        editIconInAvatarSection.shouldBe(visible).click();
    }

    public void uploadPictureFileToAvatarField(String filePath) {
        newAvatarFieldOnEditingPopup.shouldBe(visible).uploadFile(new File(filePath));
    }

    public String getAvatarInputValueOnSettingPopup() {
        String inputValue = newAvatarFieldOnEditingPopup.getValue();
        return Objects.requireNonNull(inputValue).substring(inputValue.lastIndexOf("\\") + 1);
    }

    public void setBirthDateInputValueInSettingPopup(String data) {
        birthDateFieldOnEditingPopup.shouldBe(visible).sendKeys(data);
    }

    public void clickSaveButtonInEditingProfilePopup(){
        saveButtonOnEditingPopup.shouldBe(visible).click();
    }

    public void clickCloseEditingProfilePopupWindow(){
        closeButtonOnEditingPopup.shouldBe(visible).click();
    }

    public String getBirtDateOnProfilePage() {
        return birthDateOnProfilePage.shouldBe(visible).text();
    }

    public String getFullNameFromAdditionalInfo(){
        return fullNameInAdditionalInfo.shouldBe(visible).text();
    }

    public String getFullNameFromAvatarSection(){
        return fullNameInAvatarSection.shouldBe(visible).text();
    }
}
