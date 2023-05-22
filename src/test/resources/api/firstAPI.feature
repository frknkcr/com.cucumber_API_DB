@api
Feature: Bir yönetici olarak API baglantisi üzerinden finding category listesine erisebilmeliyim.

  Scenario: /api/getFindingCategory endpoint'ine gecerli authorization bilgileri ile bir GET request gönderildiginde dönen status code'un 200 oldugu ve response message bilgisinin "Success" oldugu dogrulanmali.

    Then  "/api/getFindingCategory" endpoint'ine gecerli authorization bilgileri ile bir GET request gönderilir
    When dönen status code'un 200 oldugu ve response message bilgisinin "Success" oldugu dogrulanmali