import { Builder } from "./builder";

const user = Builder.builder()
                .setName("Sonu")
                .build();
console.log("User :",user);