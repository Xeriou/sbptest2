自己測試的模組化開發專案

主要有參考

https://github.com/j-barata/marketbasket-sbp-sample

https://github.com/zbkpointer/sbp-test


使用的是 [SBP](https://github.com/hank-cp/sbp) 這套可以將 Springboot 模組化開發的套件

## 注意

1. PluginX 跟 PluginM 不要一起 enable：因為要模擬標準 API 可以被替換的原則，因此 HelloController 的命名是一樣的，一起啟用會造成 Bean Name 的衝突，詳細起參考[application-example](config%2Fapplication-example.yaml)的 `disabled-plugins` 設定

2. 目前前端 thymeleaf 的 html 是統一指向到外部資料夾 ([templates/](templates))： PluginX 在啟動時，會跑個 [ScanFileRunner](plugins%2FPluginX%2Fsrc%2Fmain%2Fjava%2Fcom%2Fxeriou%2Fplugins%2Fpluginx%2FScanFileRunner.java)，將Jar或專案本身 templates 的 html 往外丟，達到部屬時，直接覆蓋/新增該頁面的效果。(另外的原因是，我還是沒有測試出來 thymeleaf 如何搭配目前的架構使用...持續跟進開發作者的專案吧)


## 目前狀態

此專案暫時無法非常順利運行，可能是我設定有誤，正在詢問作者...Orz