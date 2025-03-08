<template>
  <div class="container">
    <h1 style="text-align: center;">Gerenciador de Protocolo</h1>
    <NewProtocol @protocolCreated="refreshList" />
    <ProtocolList ref="protocolListRef" />
  </div>
</template>

<script setup lang="ts">
import { ref } from "vue";
import NewProtocol from "../components/Protocolo/Create.vue";
import ProtocolList from "../components/Protocolo/Index.vue";

const protocolListRef = ref<InstanceType<typeof ProtocolList> | null>(null);

const refreshList = () => {
  protocolListRef.value?.fetchProtocols();
};
</script>

<style>
.container {
  max-width: 800px;
  margin: auto;
  padding-top: 20px;
}
</style>
