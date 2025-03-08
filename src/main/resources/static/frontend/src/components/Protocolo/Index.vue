<template>
  <div class="table-container">
    <Card>
      <template #title>Lista de Protocolos</template>
      <template #content>
        <div v-if="loading" class="p-d-flex p-jc-center">
          <ProgressSpinner />
        </div>
        <DataTable v-else :value="protocols" class="p-datatable-striped">
          <Column field="id" header="ID"></Column>
          <Column field="natureza" header="Natureza">
            <template #body="slotProps">
              {{ formatNatureza(slotProps.data.natureza) }}
            </template>
          </Column>
          <Column field="dataCriacao" header="Data de Criação">
            <template #body="slotProps">
              {{ formatDate(slotProps.data.dataCriacao) }}
            </template>
          </Column>
          <Column field="dataVencimento" header="Data de Vencimento">
            <template #body="slotProps">
              {{ formatDate(slotProps.data.dataVencimento) }}
            </template>
          </Column>
        </DataTable>
      </template>
    </Card>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from "vue";
import protocoloService from "../../services/protocoloService";
import type Protocolo from "../../models/Protocolo";
import DataTable from "primevue/datatable";
import Column from "primevue/column";
import Card from "primevue/card";
import ProgressSpinner from "primevue/progressspinner";

const protocols = ref<Protocolo[]>([]);
const loading = ref<boolean>(true);

const fetchProtocols = async () => {
  loading.value = true;
  try {
    protocols.value = await protocoloService.getProtocols();
  } catch (error) {
    console.error("Erro ao buscar protocolos:", error);
  } finally {
    loading.value = false;
  }
};

onMounted(fetchProtocols);

const formatDate = (dateStr: string) => {
  return new Date(dateStr).toLocaleDateString("pt-BR");
};

const formatNatureza = (natureza: number) => {
  const naturezasMap: Record<number, string> = {
    1: "Financeiro",
    2: "Jurídico",
    3: "Administrativo",
  };
  return naturezasMap[natureza] || "Desconhecido";
};

defineExpose({ fetchProtocols });
</script>

<style scoped>
.table-container {
  max-width: 800px;
  margin: auto;
  padding-top: 20px;
}
</style>
