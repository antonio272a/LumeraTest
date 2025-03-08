<template>
  <div class="form-container">
    <Card>
      <template #title>Cadastro de Protocolo</template>
      <template #content>
        <div style="display: flex; justify-content: space-between; align-items: center;">
          <div class="p-field p-mb-3">
            <Dropdown
              id="natureza"
              v-model="selectedNatureza"
              :options="naturezas"
              optionLabel="label"
              optionValue="value"
              placeholder="Selecione a Natureza"
              class="p-inputtext-lg"
            />
          </div>
          <div class="p-mt-3">
            <Button label="Criar" icon="pi pi-plus" @click="create" class="p-button-lg" />
          </div>
        </div>
      </template>
    </Card>
  </div>
</template>

<script setup lang="ts">
import { ref } from "vue";
import { useToast } from "primevue/usetoast";
import protocoloService from "../../services/protocoloService";
import Dropdown from "primevue/dropdown";
import Button from "primevue/button";
import Card from "primevue/card";

const toast = useToast();
const emit = defineEmits(["protocolCreated"]);

const naturezas = [
  { label: "Financeiro", value: 1 },
  { label: "Jurídico", value: 2 },
  { label: "Administrativo", value: 3 },
];

const selectedNatureza = ref<number | null>(null);

const create = async () => {
  if (!selectedNatureza.value) {
    toast.add({ severity: "warn", summary: "Aviso", detail: "Selecione uma natureza!", life: 3000 });
    return;
  }

  try {
    await protocoloService.createProtocol(selectedNatureza.value);
    toast.add({ severity: "success", summary: "Sucesso", detail: "Protocolo Criado!", life: 3000 });
    selectedNatureza.value = null;
    emit("protocolCreated");
  } catch (error) {
    console.error("Erro ao criar protocolo:", error);
    toast.add({ severity: "error", summary: "Erro", detail: "Erro ao criar protocolo", life: 3000 });
  }
};
</script>

<style scoped>
.form-container {
  max-width: 400px;
  margin: auto;
  padding-top: 20px;
}
</style>
