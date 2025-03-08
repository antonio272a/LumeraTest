import { createApp } from "vue";
import App from "./App.vue";
import PrimeVue from "primevue/config";
import Aura from "@primeuix/themes/aura";

import "primeicons/primeicons.css";
import router from "./router";
import { ToastService } from "primevue";

const app = createApp(App);

app.use(PrimeVue, {
  theme: {
    preset: Aura,
  },
});

app.use(router);
app.use(ToastService)

app.mount("#app");