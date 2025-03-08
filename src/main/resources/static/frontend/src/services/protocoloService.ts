import axios from "axios";
import type Protocolo from "../models/Protocolo";

const API_URL = "http://localhost:8080/api/protocolos";

export default {
  async getProtocols(): Promise<Protocolo[]> {
    const response = await axios.get<Protocolo[]>(API_URL);
    return response.data;
  },

  async createProtocol(natureza: number): Promise<void> {
    await axios.post(API_URL, { natureza });
  },
};
